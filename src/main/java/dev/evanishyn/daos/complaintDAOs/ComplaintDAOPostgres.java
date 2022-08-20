package dev.evanishyn.daos.complaintDAOs;

import dev.evanishyn.entities.Complaint;
import dev.evanishyn.utilities.enums.ConnectionUtil;
import dev.evanishyn.utilities.enums.Priority;
import dev.evanishyn.utilities.enums.Status;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ComplaintDAOPostgres implements ComplaintDAO{

    //-----post-----
    @Override
    public Complaint createComplaint(Complaint complaint) {
        try(Connection conn = ConnectionUtil.createConnection()){
            String sql = "insert into complaint values(default, ?, ?, ?, default)";
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            //check for null pointer exception!

            ps.setString(1, complaint.getDescription());//description
            ps.setString(2, Status.PENDING.name());     //status
            ps.setString(3, Priority.TBD.name());       //priority

            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            rs.next();

            int generateKey = rs.getInt("complaint_id");
            complaint.setComplaint_id(generateKey);
//            complaint.setStatus(Status.PENDING);
            return complaint;

        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    //-----get [x2]-----
    // 1] get all complaints
    @Override
    public List<Complaint> getAllComplaints() {
        try (Connection conn = ConnectionUtil.createConnection()) {
            String sql = "select * from complaint";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            List<Complaint> complaintList = new ArrayList<>();

            while(rs.next()){
                Complaint complaint = new Complaint();
                complaint.setComplaint_id(rs.getInt("complaint_id"));
                complaint.setDescription(rs.getString("description"));
                complaint.setStatus(Status.valueOf(rs.getString("status")));
                complaint.setPriority(Priority.valueOf(rs.getString("priority")));
                complaint.setM_id(rs.getInt("m_id"));
                complaintList.add(complaint);
            }
            return complaintList;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Complaint getComplaintById(int id) {
        try (Connection conn = ConnectionUtil.createConnection()){
            String sql = "select * from complaint where complaint_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            rs.next();

                Complaint complaint = new Complaint();
                complaint.setComplaint_id(rs.getInt("complaint_id"));
                complaint.setDescription(rs.getString("description"));
                complaint.setStatus(Status.valueOf(rs.getString("status")));
                complaint.setPriority(Priority.valueOf(rs.getString("priority")));
                complaint.setM_id(rs.getInt("m_id"));

                return complaint;

        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    // 2] get complaint by id (Members)



    //-----patch [x2]-----
    // 1] update status

    // 2] update priority

    //-----delete-----
}


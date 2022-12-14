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

            int generateKey = rs.getInt("complaintid");
            complaint.setComplaintId(generateKey);
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
                complaint.setComplaintId(rs.getInt("complaintid"));
                complaint.setDescription(rs.getString("description"));
                complaint.setStatus(Status.valueOf(rs.getString("status")));
                complaint.setPriority(Priority.valueOf(rs.getString("priority")));
                complaint.setmId(rs.getInt("mid"));
                complaintList.add(complaint);
            }
            return complaintList;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // 2] get complaint by id (Members)
    @Override
    public Complaint getComplaintById(int id) {
        try (Connection conn = ConnectionUtil.createConnection()){
            String sql = "select * from complaint where complaintid = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            rs.next();

                Complaint complaint = new Complaint();
                complaint.setComplaintId(rs.getInt("complaintid"));
                complaint.setDescription(rs.getString("description"));
                complaint.setStatus(Status.valueOf(rs.getString("status")));
                complaint.setPriority(Priority.valueOf(rs.getString("priority")));
                complaint.setmId(rs.getInt("mid"));


                return complaint;



        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Complaint updateComplaintForm(Complaint complaint) {
        try(Connection conn = ConnectionUtil.createConnection()){
            String sql = "update complaint set description = ?, status = ?, priority = ?, mid = ? where complaintid = ?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, complaint.getDescription());
            ps.setString(2, complaint.getStatus().name());
            ps.setString(3, complaint.getPriority().name());
            ps.setInt(4, complaint.getmId());
            ps.setInt(5, complaint.getComplaintId());

            ps.executeUpdate();
            return complaint;

        }
        catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }


    //-----patch [x2]-----
    // 1] update status
    @Override
    public Complaint updateComplaintStatus(Complaint complaint, Status status) {
        try(Connection conn = ConnectionUtil.createConnection()){
            String sql = "update complaint set status = ? where complaintid = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, status.name());
            ps.setInt(2, complaint.getComplaintId());

            ps.executeUpdate();
            return complaint;

        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    // 2] update priority
    public Complaint updateComplaintPriority(Complaint complaint, Priority priority){
        try(Connection conn = ConnectionUtil.createConnection()){
            String sql = "update complaint set priority = ? where complaintid = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, priority.name());
            ps.setInt(2, complaint.getComplaintId());

            ps.executeUpdate();
            return complaint;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Complaint updateComplaintWithMeetingId(Complaint complaint, int mId) {
        try(Connection conn = ConnectionUtil.createConnection()){
            String sql = "update complaint set mid = ? where complaintid = ?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, mId);
            ps.setInt(2, complaint.getComplaintId());
            ps.executeUpdate();

            return complaint;

        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }


    //-----delete-----
}


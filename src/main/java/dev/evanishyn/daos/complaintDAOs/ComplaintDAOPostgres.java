package dev.evanishyn.daos.complaintDAOs;

import dev.evanishyn.entities.Complaint;
import dev.evanishyn.utilities.enums.ConnectionUtil;
import dev.evanishyn.utilities.enums.Priority;
import dev.evanishyn.utilities.enums.Status;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class ComplaintDAOPostgres implements ComplaintDAO{

    //-----post-----
    @Override
    public Complaint createComplaint(Complaint complaint) {
        try(Connection conn = ConnectionUtil.createConnection()){
            String sql = "insert into complaint values(default, ?, ?, ?, default)";
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); //check for null pointer exception!

            ps.setString(1, complaint.getDescription());//description
            ps.setString(2, Status.PENDING.name());     //status
            ps.setString(3, Priority.TBD.name());       //priority

            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            rs.next();

            int generateKey = rs.getInt("complaint_id");
            complaint.setId(generateKey);
            complaint.setStatus(Status.PENDING);
            return complaint;

        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }


    //-----get [x2]-----
    // 1] get all complaints

    // 2] get complaint by id (Members)

    //-----put-----

    //-----patch [x2]-----
    // 1] update status

    // 2] update priority

    //-----delete-----
}


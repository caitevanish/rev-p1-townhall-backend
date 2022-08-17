package dev.evanishyn.daos.meetingDAOs;

import dev.evanishyn.entities.Meeting;
import dev.evanishyn.utilities.enums.ConnectionUtil;
import dev.evanishyn.utilities.enums.Status;

import java.sql.*;

public class MeetingDAOPostgres implements MeetingDAO{

    //-----post-----
    @Override
    public Meeting createMeeting(Meeting meeting) {
        try(Connection conn = ConnectionUtil.createConnection()){
            String sql = "insert into meeting values(default, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            //possible nullpointer exception here

            ps.setInt(1, meeting.getMeet_time());
            ps.setString(2, meeting.getLocation());
            ps.setString(3, meeting.getSummary());

            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            rs.next();

            int generateKey = rs.getInt("meet_id");
            meeting.setId(generateKey);
            return meeting;

        }catch (SQLException e){
            e.printStackTrace();
        }
            return null;
    }


    //-----get [x2]-----
    // 1] get all meetings


    //-----put-----
    // 1] update meeting date and location
}

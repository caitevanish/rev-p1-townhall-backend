package dev.evanishyn.daos.meetingDAOs;

import dev.evanishyn.entities.Meeting;
import dev.evanishyn.utilities.enums.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MeetingDAOPostgres implements MeetingDAO{

    //-----post-----
    @Override
    public Meeting createMeeting(Meeting meeting) {
        try(Connection conn = ConnectionUtil.createConnection()){
            String sql = "insert into meeting values(default, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            //possible nullpointer exception here

            ps.setInt(1, meeting.getTime());
            ps.setString(2, meeting.getLocation());
            ps.setString(3, meeting.getSummary());

            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            rs.next();

            int generateKey = rs.getInt("meetid");
            meeting.setMeetId(generateKey);
            return meeting;

        }catch (SQLException e){
            e.printStackTrace();
        }
            return null;
    }

    //-----get [x2]-----
    // 1] get all meetings
    @Override
    public List<Meeting> getAllMeetings() {
        try(Connection conn = ConnectionUtil.createConnection()){
            String sql = "select * from meeting";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            List<Meeting> meetingList = new ArrayList<>();

            while(rs.next()){
                Meeting meeting = new Meeting();
                meeting.setMeetId(rs.getInt("meetid"));
                meeting.setTime(rs.getInt("time"));
                meeting.setLocation(rs.getString("location"));
                meeting.setSummary(rs.getString("summary"));
                meetingList.add(meeting);
            }
            return meetingList;

        }catch(SQLException e){
            e.printStackTrace();
        }
            return null;
    }

    @Override
    public Meeting getMeetingById(int id) {
        try (Connection conn = ConnectionUtil.createConnection()) {
            String sql = "select * from meeting where meetid = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            rs.next();

            Meeting meeting = new Meeting();
            meeting.setMeetId(rs.getInt("meetid"));
            meeting.setTime(rs.getInt("time"));
            meeting.setLocation(rs.getString("location"));
            meeting.setSummary(rs.getString("summary"));

            return meeting;
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }


    //-----put-----
    // 1] update meeting date and location
}

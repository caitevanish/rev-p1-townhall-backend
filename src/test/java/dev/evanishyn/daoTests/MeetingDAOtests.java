package dev.evanishyn.daoTests;

import dev.evanishyn.daos.meetingDAOs.MeetingDAOPostgres;
import dev.evanishyn.entities.Meeting;
import dev.evanishyn.utilities.enums.ConnectionUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;



public class MeetingDAOtests {

    @BeforeAll
    static void setup_meeting(){
        try(Connection conn = ConnectionUtil.createConnection()){
            String sql = "create table meeting(meet_id serial primary key, time int default -1, location varchar (100), summary varchar (2000) not null)";
            Statement st = conn.createStatement();  //Check for null pointer Exception!
            st.execute(sql);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    static MeetingDAOPostgres meetingDAO = new MeetingDAOPostgres();

    //-----post-----

    @Test   //Passed
    void create_meeting_dTest(){
        Meeting meeting = new Meeting(0, 1660675993, "The Hogshead, Hogsmead", "Discussing the annoyances of nomaj neighbors");
        Meeting scheduledMeeting = meetingDAO.createMeeting(meeting);
        Assertions.assertEquals(1, scheduledMeeting.getId());
    }


    //-----get [x2]-----
    // 1] get all meetings


    //-----put-----
    // 1] update meeting date and location
}

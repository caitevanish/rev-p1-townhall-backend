package dev.evanishyn.daoTests;

import dev.evanishyn.daos.meetingDAOs.MeetingDAOPostgres;
import dev.evanishyn.entities.Meeting;
import dev.evanishyn.utilities.enums.ConnectionUtil;
import org.junit.jupiter.api.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class MeetingDAOtests {


    static MeetingDAOPostgres meetingDAO = new MeetingDAOPostgres();

//    List<Meeting> meetingList = meetingDAO.getAllMeetings();

    @Disabled
    @BeforeAll
    static void teardown_complaint(){
        try(Connection conn = ConnectionUtil.createConnection()){
            String sql = "drop table complaint";
            Statement statement = conn.createStatement();
            statement.execute(sql);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @BeforeAll
    static void teardown_meeting(){
        try(Connection conn = ConnectionUtil.createConnection()){
            String sql = "drop table meeting";
            Statement statement = conn.createStatement();
            statement.execute(sql);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }


    @Test
    @Order(1)
    void setup_meeting(){
        try(Connection conn = ConnectionUtil.createConnection()){
            String sql = "create table meeting(id serial primary key, time int default -1, location varchar (100), summary varchar (2000) not null)";
            Statement st = conn.createStatement();  //Check for null pointer Exception!
            st.execute(sql);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }




    @Test
    @Order(2)
    void create_default_unsaved_meeting_entry(){
        try(Connection conn = ConnectionUtil.createConnection()){
            String sql = "insert into meeting values(-1, 0, 'LOCATION TBD2222', 'No meeting agenda yet')";
            Statement st = conn.createStatement();
            st.execute(sql);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    //-----post-----

    @Test   //Passed
    @Order(3)
    void create_meeting_dTest(){
        Meeting meeting = new Meeting(0, 1660675993, "The Hogshead, Hogsmead", "Discussing the annoyances of nomaj neighbors");
        Meeting scheduledMeeting = meetingDAO.createMeeting(meeting);
        Assertions.assertEquals(1, scheduledMeeting.getId());
    }


    //-----get [x2]-----
    // 1] get all meetings
    @Test
    @Order(4)
    void get_all_meetings_dTest(){
        Meeting meeting = new Meeting(0, 1660675993, "The OTHER Hogshead, Mass.", "Direct all your complaints to the stump on the hill");
        meetingDAO.createMeeting(meeting);

        List<Meeting> meetingList = meetingDAO.getAllMeetings();
        Assertions.assertEquals(3, meetingList.size());
//        System.out.println(meetingList);
    }



    //-----put-----
    // 1] update meeting date and location
}

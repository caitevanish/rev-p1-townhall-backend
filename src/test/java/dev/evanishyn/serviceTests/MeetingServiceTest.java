package dev.evanishyn.serviceTests;

import dev.evanishyn.daos.meetingDAOs.MeetingDAO;
import dev.evanishyn.daos.meetingDAOs.MeetingDAOPostgres;
import dev.evanishyn.entities.Meeting;
import dev.evanishyn.services.MeetingServiceImpl;
import dev.evanishyn.services.interfaces.MeetingService;
import org.junit.jupiter.api.*;

import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class MeetingServiceTest {

    static MeetingDAO meetingDAO = new MeetingDAOPostgres();
    static MeetingService meetingService = new MeetingServiceImpl(meetingDAO);


    //-----post-----
    @Test
    @Order(1)
    void create_meeting_sTest(){
        Meeting newMeeting = new Meeting(0, 1661288424, "The Poisoned Pen", "Hogs got swine flu and turning green");
        Meeting savedMeeting = meetingService.createMeeting(newMeeting);
        Assertions.assertNotEquals(-1, savedMeeting.getMeet_id());
    }


    //-----get [x2]-----
    @Test
    @Order(2)
    void get_all_meetings_sTest(){
        Meeting meeting2 = new Meeting(0, 1661288424, "The Rotting Gut", "Wifi isn't working behind your charm of concealment");
        Meeting meeting3 = new Meeting(0, 1661288424, "The Old Witches Hump", "Kids are making rude witch stereotypes");

        meetingDAO.createMeeting(meeting2);
        meetingDAO.createMeeting(meeting3);

        List<Meeting> meetingList = meetingDAO.getAllMeetings();
        Assertions.assertNotEquals(1, meetingList.size());
    }

    @Test
    @Order(3)
    void get_meeting_by_id_sTest(){
        Meeting meeting = meetingDAO.getMeetingById(3);
        Assertions.assertEquals("PDAs: Does and Do Not's", meeting.getSummary());
    }
    //-----put-----
}

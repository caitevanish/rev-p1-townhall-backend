package dev.evanishyn.serviceTests;

import dev.evanishyn.daos.meetingDAOs.MeetingDAO;
import dev.evanishyn.daos.meetingDAOs.MeetingDAOPostgres;
import dev.evanishyn.entities.Meeting;
import dev.evanishyn.services.MeetingServiceImpl;
import dev.evanishyn.services.interfaces.MeetingService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MeetingServiceTest {

    static MeetingDAO meetingDAO = new MeetingDAOPostgres();
    static MeetingService meetingService = new MeetingServiceImpl(meetingDAO);


    //-----post-----
    @Test
    void create_meeting_sTest(){
        Meeting newMeeting = new Meeting(0, 1661288424, "The Poisoned Pen", "Hogs got swine flu and turning green");
        Meeting savedMeeting = meetingService.createMeeting(newMeeting);
        Assertions.assertNotEquals(-1, savedMeeting.getId());
    }


    //-----get [x2]-----
    @Test
    void get_all_meetings_sTest(){
        Meeting meeting2 = new Meeting(0, 1661288424, "The Rotting Gut", "Wifi isn't working behind your charm of concealment");
        Meeting meeting3 = new Meeting(0, 1661288424, "The Old Witches Hump", "Kids are making rude witch stereotypes");

        meetingDAO.createMeeting(meeting2);
        meetingDAO.createMeeting(meeting3);

        List<Meeting> meetingList = meetingDAO.getAllMeetings();
        Assertions.assertNotEquals(1, meetingList.size());

    }
    //-----put-----
}

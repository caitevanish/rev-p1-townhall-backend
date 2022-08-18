package dev.evanishyn.daos.meetingDAOs;

import dev.evanishyn.entities.Meeting;

import java.util.List;

public interface MeetingDAO{

    //-----post-----
    Meeting createMeeting(Meeting meeting);


    //-----get [x2]-----
    // 1] get all meetings
    List<Meeting> getAllMeetings();


    //-----put-----
    // 1] update meeting date and location


}

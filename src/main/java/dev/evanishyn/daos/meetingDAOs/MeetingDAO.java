package dev.evanishyn.daos.meetingDAOs;

import dev.evanishyn.entities.Complaint;
import dev.evanishyn.entities.Meeting;

import java.util.List;

public interface MeetingDAO{

    //-----post-----
    Meeting createMeeting(Meeting meeting);


    //-----get [x2]-----
    // 1] get all meetings
    List<Meeting> getAllMeetings();

    // 2] get meeting by id
    Meeting getMeetingById(int id);


    //-----put-----
    // 1] update meeting date and location


}

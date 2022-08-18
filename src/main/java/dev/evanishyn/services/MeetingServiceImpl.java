package dev.evanishyn.services;

import dev.evanishyn.daos.meetingDAOs.MeetingDAO;
import dev.evanishyn.entities.Meeting;
import dev.evanishyn.services.interfaces.MeetingService;

import java.util.List;


public class MeetingServiceImpl implements MeetingService {

    private MeetingDAO meetingDAO;

    public MeetingServiceImpl(MeetingDAO meetingDAO){this.meetingDAO = meetingDAO;}

    @Override
    //Must add that ONLY council member account types can make a meeting
    public Meeting createMeeting(Meeting meeting) {
        if(meeting.getMeet_id()!=0){
            if(meeting.getSummary().length()<20){
                throw new RuntimeException("Need a more detailed description");
            }
        }
        return this.meetingDAO.createMeeting(meeting);
    }

    @Override
    public List<Meeting> getAllMeetings() {
        return meetingDAO.getAllMeetings();
    }

    @Override
    public Meeting getMeetingById(int id) {
        return meetingDAO.getMeetingById(id);
    }


}

package dev.evanishyn.services;

import dev.evanishyn.daos.meetingDAOs.MeetingDAO;
import dev.evanishyn.entities.Meeting;
import dev.evanishyn.services.interfaces.MeetingService;



public class MeetingServiceImpl implements MeetingService {

    private MeetingDAO meetingDAO;

    public MeetingServiceImpl(MeetingDAO meetingDAO){this.meetingDAO = meetingDAO;}

    @Override
    public Meeting createMeeting(Meeting meeting) {
        if(meeting.getId()!=0){
            if(meeting.getSummary().length()<20){
                throw new RuntimeException("Need a more detailed description");
            }
        }
        return this.meetingDAO.createMeeting(meeting);
    }
}

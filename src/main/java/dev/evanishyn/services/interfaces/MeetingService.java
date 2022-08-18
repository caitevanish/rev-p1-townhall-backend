package dev.evanishyn.services.interfaces;

import dev.evanishyn.entities.Meeting;

import java.util.List;

public interface MeetingService {

    Meeting createMeeting(Meeting meeting);

    List<Meeting> getAllMeetings();
}

package dev.evanishyn.services.interfaces;

//    Business Rules:


import dev.evanishyn.entities.Complaint;
import dev.evanishyn.utilities.enums.Priority;
import dev.evanishyn.utilities.enums.Status;

import java.util.List;

public interface ComplaintService {

    Complaint createComplaint(Complaint complaint);

    List<Complaint> getAllComplaints();

    Complaint getComplaintById(int id);

    Complaint updateComplaintForm(Complaint complaint);

    Complaint updateComplaintStatus(Complaint complaint, Status status);

    Complaint updateComplaintPriority(Complaint complaint, Priority priority);

    Complaint updateComplaintWithMeetingId(Complaint complaint, int mid);
}

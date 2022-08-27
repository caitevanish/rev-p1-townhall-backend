package dev.evanishyn.daos.complaintDAOs;

import dev.evanishyn.entities.Complaint;
import dev.evanishyn.utilities.enums.Priority;
import dev.evanishyn.utilities.enums.Status;

import java.util.List;

public interface ComplaintDAO {

    //-----post-----
    Complaint createComplaint(Complaint complaint);

    //-----get [x2]-----
    // 1] get all complaints
    List<Complaint> getAllComplaints();

    // 2] get complaint by id (Members)
    Complaint getComplaintById(int id);

    //-----patch [x2]-----
    // 1] Member: Patch a complaint's pritority and status
    Complaint updateComplaintStatus(Complaint complaint, Status status);

    Complaint updateComplaintPriority(Complaint complaint, Priority priority);

    // 2] Member: Attach a complaint to a meeting
    Complaint updateComplaintWithMeetingId(Complaint complaint, int meetId);

    //-----delete-----

}

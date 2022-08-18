package dev.evanishyn.services.interfaces;

//    Business Rules:


import dev.evanishyn.entities.Complaint;

import java.util.List;

public interface ComplaintService {

    Complaint createComplaint(Complaint complaint);

    List<Complaint> getAllComplaints();

    Complaint getComplaintById(int id);

}

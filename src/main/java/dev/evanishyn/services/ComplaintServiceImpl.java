package dev.evanishyn.services;

import dev.evanishyn.daos.complaintDAOs.ComplaintDAO;
import dev.evanishyn.entities.Complaint;
import dev.evanishyn.services.interfaces.ComplaintService;
import dev.evanishyn.utilities.enums.Priority;
import dev.evanishyn.utilities.enums.Status;

import java.util.List;

public class ComplaintServiceImpl implements ComplaintService {

    private ComplaintDAO complaintDAO;

    public ComplaintServiceImpl(ComplaintDAO complaintDAO){ this.complaintDAO = complaintDAO;}
    
    //-----post-----
    @Override
    public Complaint createComplaint(Complaint complaint) {
        //check for id
        if (complaint.getComplaintId() != 0) {
            if(complaint.getDescription().length() < 20) {    //check for enough description
                throw new RuntimeException("Need a more detailed description");
            }
        }
        return this.complaintDAO.createComplaint(complaint);

//        throw new RuntimeException("The id for complaint is no good");
    }

    //-----get [x2]-----
    // 1] get all complaints

    @Override
    public List<Complaint> getAllComplaints() {
        return complaintDAO.getAllComplaints();
    }


    // 2] get complaint by id (Members)

    @Override
    public Complaint getComplaintById(int id) {
        return complaintDAO.getComplaintById(id);
    }


    @Override
    public Complaint updateComplaintStatus(Complaint complaint, Status status) {
        return this.complaintDAO.updateComplaintStatus(complaint, status);
    }

    @Override
    public Complaint updateComplaintPriority(Complaint complaint, Priority priority) {
        return this.complaintDAO.updateComplaintPriority(complaint, priority);
    }

    @Override
    public Complaint updateComplaintWithMeetingId(Complaint complaint, int mid) {
        return this.complaintDAO.updateComplaintWithMeetingId(complaint, mid);

    }


}

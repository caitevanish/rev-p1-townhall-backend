package dev.evanishyn.services;

import dev.evanishyn.daos.complaintDAOs.ComplaintDAO;
import dev.evanishyn.entities.Complaint;
import dev.evanishyn.services.interfaces.ComplaintService;

public class ComplaintServiceImpl implements ComplaintService {

    private ComplaintDAO complaintDAO;

    public ComplaintServiceImpl(ComplaintDAO complaintDAO){ this.complaintDAO = complaintDAO;}
    
    //-----post-----
    @Override
    public Complaint createComplaint(Complaint complaint) {
        //check for id
        if (complaint.getId() != 0) {
            if(complaint.getDescription().length() < 20) {    //check for enough description
                throw new RuntimeException("Need a more detailed description");
            }
        }
        return this.complaintDAO.createComplaint(complaint);

//        throw new RuntimeException("The id for complaint is no good");
    }


    //-----get [x2]-----
    // 1] get all complaints

    // 2] get complaint by id (Members)

    //-----put-----

    //-----patch [x2]-----
    // 1] update status

    // 2] update priority

    //-----delete-----
    
    
    

}

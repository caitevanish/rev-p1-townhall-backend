package dev.evanishyn.serviceTests;

import dev.evanishyn.daos.complaintDAOs.ComplaintDAO;
import dev.evanishyn.daos.complaintDAOs.ComplaintDAOPostgres;
import dev.evanishyn.entities.Complaint;
import dev.evanishyn.services.ComplaintServiceImpl;
import dev.evanishyn.services.interfaces.ComplaintService;
import dev.evanishyn.utilities.enums.Priority;
import dev.evanishyn.utilities.enums.Status;
import org.junit.jupiter.api.*;

import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class ComplaintServiceTests {

    static ComplaintDAO complaintDAO = new ComplaintDAOPostgres();
    static ComplaintService complaintService = new ComplaintServiceImpl(complaintDAO);

    //-----post-----
    @Test
    @Order(1)
    void create_complaint_sTest(){
        Complaint newComplaint = new Complaint(0, "The neighbor's owls are too loud", Status.PENDING, Priority.TBD, 0);
        Complaint savedComplaint = complaintService.createComplaint(newComplaint);
        Assertions.assertEquals("PENDING", savedComplaint.getStatus().name());

        //When I get meeting id from db it is saying it's 0, not -1
    }

    //-----get [x2]-----
    // 1] get all complaints
    @Test
    @Order(2)
    void get_all_complaints_sTest(){
        Complaint complaint2 = new Complaint(0, "The construction is messing with the ley lines", Status.PENDING, Priority.TBD, 0);
        Complaint complaint3 = new Complaint(0, "I'm quite sure my neighbor hexed me", Status.PENDING, Priority.TBD, 0);

        complaintDAO.createComplaint(complaint2);
        complaintDAO.createComplaint(complaint3);

        List<Complaint> complaintList = complaintDAO.getAllComplaints();
        Assertions.assertEquals(3, complaintList.size());
    }


    // 2] get complaint by id (Members)
    @Test
    @Order(3)
    void get_complaint_by_id_sTest(){
        Complaint complaint = complaintDAO.getComplaintById(2);
        Assertions.assertEquals("The construction is messing with the ley lines", complaint.getDescription());
    }
//
//    @Test
//    @Order(4)
//    void update_complaint_test(){
//        Complaint complaint = new Complaint(3, "The vibe in this room is awful", Status.APPROVED, Priority.LOW, 0);
//        complaintService.updateComplaintDetails(complaint, complaint.getStatus(), complaint.getPriority());
//        Complaint newComplaint = complaintService.getComplaintById(3);
//        Assertions.assertEquals(Priority.LOW, newComplaint.getPriority());
//    }

    //-----put-----

    //-----patch [x2]-----
    // 1] update status

    // 2] update priority

    //-----delete-----

}

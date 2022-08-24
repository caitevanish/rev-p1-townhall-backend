package dev.evanishyn.daoTests;


import dev.evanishyn.daos.complaintDAOs.ComplaintDAOPostgres;
import dev.evanishyn.entities.Complaint;
import dev.evanishyn.utilities.enums.ConnectionUtil;
import dev.evanishyn.utilities.enums.Priority;
import dev.evanishyn.utilities.enums.Status;
import org.junit.jupiter.api.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class ComplaintDAOtests {

    static ComplaintDAOPostgres complaintDAO = new ComplaintDAOPostgres();

//    @Disabled
    @BeforeAll
    static void teardown(){
        try(Connection conn = ConnectionUtil.createConnection()){
            String sql = "drop table complaint";
            Statement statement = conn.createStatement();
            statement.execute(sql);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }


    @Test
    @Order(1)
    void setup_complaint(){
        try(Connection conn = ConnectionUtil.createConnection()){
            String sql = "create table complaint(\n" +
                    "\tcomplaintid serial primary key,\t\n" +
                    "\tdescription varchar(2000) not null,\n" +
                    "\tstatus varchar(10) default 'PENDING',\n" +
                    "\tpriority varchar(10) default 'TBD' ,\n" +
                    "\tmid int references meeting(meetid) default -1\n" +
                    ")";
            Statement st = conn.createStatement();  //Check for null pointer Exception!
            st.execute(sql);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }



    //-----post-----

    @Test
    @Order(2)   //Passed
    void create_complaint_dTest(){
        Complaint complaint = new Complaint(0, "The neighbors are too loud", Status.PENDING, Priority.TBD, 0);
        Complaint savedComplaint = complaintDAO.createComplaint(complaint);
        Assertions.assertNotEquals(0, savedComplaint.getComplaintId());
    }



    //-----get [x2]-----
    // 1] get all complaints

    @Test   //Passed
    @Order(3)
    void get_all_complaints_dTest(){
        Complaint complaint2 = new Complaint(0, "The construction is messing with the ley lines", Status.PENDING, Priority.TBD, 0);
        Complaint complaint3 = new Complaint(0, "I'm quite sure my neighbor hexed me", Status.PENDING, Priority.TBD, 0);

        complaintDAO.createComplaint(complaint2);
        complaintDAO.createComplaint(complaint3);

        List<Complaint> complaintList = complaintDAO.getAllComplaints();
        Assertions.assertEquals(3, complaintList.size());
    }

//     2] get complaint by id (Members)

    @Test   //Passed
    @Order(4)
    void get_complaint_by_id_dTest(){
        Complaint complaint = complaintDAO.getComplaintById(2);
        Assertions.assertEquals("The construction is messing with the ley lines", complaint.getDescription());
    }


    //-----patch [x2]-----
    // 1] update status

    // 2] update priority
    @Test
    @Order(5)
    void update_complaint_StatusPrior_by_Id_dTest(){
        Complaint updComplaint = complaintDAO.getComplaintById(1);
        updComplaint.setStatus(Status.DENIED);
        updComplaint.setPriority(Priority.LOW);
        complaintDAO.updateComplaintDetails(updComplaint, updComplaint.getStatus(), updComplaint.getPriority());
        Assertions.assertNotEquals(Status.PENDING, updComplaint.getStatus());
    }

    @Test
    @Order(6)
    void update_complaint_with_meeting_id_dTest(){
        Complaint complaint = complaintDAO.getComplaintById(1);
        complaint.setmId(2);
        complaintDAO.updateComplaintWithMeetingId(complaint, 2);
        Assertions.assertNotEquals(-1, complaint.getmId());

    }


    //-----delete-----


}

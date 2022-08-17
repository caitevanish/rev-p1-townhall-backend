package dev.evanishyn.daoTests;

import dev.evanishyn.daos.complaintDAOs.ComplaintDAO;
import dev.evanishyn.daos.complaintDAOs.ComplaintDAOPostgres;
import dev.evanishyn.entities.Complaint;
import dev.evanishyn.utilities.enums.ConnectionUtil;
import dev.evanishyn.utilities.enums.Priority;
import dev.evanishyn.utilities.enums.Status;
import org.junit.jupiter.api.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class ComplaintDAOtests {

//    @Disabled
//    @BeforeAll
//    static void teardown(){
//        try(Connection conn = ConnectionUtil.createConnection()){
//            String sql = "drop table complaint";
//            Statement statement = conn.createStatement();
//            statement.execute(sql);
//        }catch(SQLException e){
//            e.printStackTrace();
//        }
//    }

    //Move to meetings in future
//    @Disabled
//    @BeforeAll
//    static void set_default_meeting(){
//        try(Connection conn = ConnectionUtil.createConnection()){
//            String sql = "insert into meeting values(-1, 0, 'LOCATION TBD', 'No meeting agenda yet')";
//            Statement statement = conn.createStatement();
//            statement.execute(sql);
//        }catch(SQLException e){
//            e.printStackTrace();
//        }
//    }

    @BeforeAll
    static void setup_complaint(){
        try(Connection conn = ConnectionUtil.createConnection()){
            String sql = "create table complaint(\n" +
                    "\tcomplaint_id serial primary key,\t\n" +
                    "\tdescription varchar(2000) not null,\n" +
                    "\tstatus varchar(10) default 'PENDING',\n" +
                    "\tpriority varchar(10) default 'TBD' ,\n" +
                    "\tm_id int references meeting(meet_id) default -1\n" +
                    ")";
            Statement st = conn.createStatement();  //Check for null pointer Exception!
            st.execute(sql);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    static ComplaintDAOPostgres complaintDAO = new ComplaintDAOPostgres();

    //-----post-----

    @Test
    @Order(1)   //Passed
    void create_complaint_dTest(){
        Complaint complaint = new Complaint(0, "The neighbors are too loud", Status.PENDING, Priority.TBD, 0);
        Complaint savedComplaint = complaintDAO.createComplaint(complaint);
        Assertions.assertNotEquals(0, savedComplaint.getId());
    }



    //-----get [x2]-----
    // 1] get all complaints

    // 2] get complaint by id (Members)


    //-----patch [x2]-----
    // 1] update status

    // 2] update priority

    //-----delete-----


}

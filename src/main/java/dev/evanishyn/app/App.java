package dev.evanishyn.app;

import dev.evanishyn.daos.complaintDAOs.ComplaintDAOPostgres;
import dev.evanishyn.daos.meetingDAOs.MeetingDAOPostgres;
import dev.evanishyn.handlers.complaint.CreateNewComplaintHandler;
import dev.evanishyn.handlers.meeting.CreateNewMeetingHandler;
import dev.evanishyn.services.ComplaintServiceImpl;
import dev.evanishyn.services.MeetingServiceImpl;
import dev.evanishyn.services.interfaces.ComplaintService;
import dev.evanishyn.services.interfaces.MeetingService;
import io.javalin.Javalin;

public class App {

    public static ComplaintService complaintService = new ComplaintServiceImpl(new ComplaintDAOPostgres());
    public static MeetingService meetingService = new MeetingServiceImpl(new MeetingDAOPostgres());

    public static void main(String[] args) {
        Javalin app = Javalin.create(config->{

            config.enableCorsForAllOrigins();
        });


        //-----------Account User-----------



        //-----------Complaint-----------
        CreateNewComplaintHandler createNewComplaintHandler = new CreateNewComplaintHandler();



        app.post("/complaints", createNewComplaintHandler);


        //-----------Meeting-----------
        CreateNewMeetingHandler createNewMeetingHandler = new CreateNewMeetingHandler();


        app.post("/meetings", createNewMeetingHandler);

        app.start();
    }
}

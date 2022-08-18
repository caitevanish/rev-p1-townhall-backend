package dev.evanishyn.app;

import dev.evanishyn.daos.complaintDAOs.ComplaintDAOPostgres;
import dev.evanishyn.daos.meetingDAOs.MeetingDAOPostgres;
import dev.evanishyn.handlers.complaint.CreateNewComplaintHandler;
import dev.evanishyn.handlers.complaint.GetAllComplaintsHandler;
import dev.evanishyn.handlers.complaint.GetComplaintByIdHandler;
import dev.evanishyn.handlers.meeting.CreateNewMeetingHandler;
import dev.evanishyn.handlers.meeting.GetAllMeetingsHandler;
import dev.evanishyn.handlers.meeting.GetMeetingByIdHandler;
import dev.evanishyn.services.ComplaintServiceImpl;
import dev.evanishyn.services.MeetingServiceImpl;
import dev.evanishyn.services.interfaces.ComplaintService;
import dev.evanishyn.services.interfaces.MeetingService;
import io.javalin.Javalin;
import io.javalin.http.Handler;

public class App {

    public static ComplaintService complaintService = new ComplaintServiceImpl(new ComplaintDAOPostgres());
    public static MeetingService meetingService = new MeetingServiceImpl(new MeetingDAOPostgres());

    public static void main(String[] args) {
        Javalin app = Javalin.create(config->{  //Statement lambda can be replaced with expression lambda
            config.enableCorsForAllOrigins();   //Lambda can be replaced with method reference
        });
        //wrap a try-with resources statement




        //-----------Account User-----------



        //-----------Complaint-----------
        CreateNewComplaintHandler createNewComplaintHandler = new CreateNewComplaintHandler();
        GetAllComplaintsHandler getAllComplaintsHandler = new GetAllComplaintsHandler();
        GetComplaintByIdHandler getComplaintByIdHandler = new GetComplaintByIdHandler();

        app.post("/complaints", createNewComplaintHandler);
        app.get("/complaints", getAllComplaintsHandler);
        app.get("/complaints/{id}", getComplaintByIdHandler);


        //-----------Meeting-----------
        CreateNewMeetingHandler createNewMeetingHandler = new CreateNewMeetingHandler();
        GetAllMeetingsHandler getAllMeetingsHandler = new GetAllMeetingsHandler();
        GetMeetingByIdHandler getMeetingByIdHandler = new GetMeetingByIdHandler();


        app.post("/meetings", createNewMeetingHandler);
        app.get("/meetings", getAllMeetingsHandler);
        app.get("/meetings/{id}", getMeetingByIdHandler);




        app.start();
    }
}

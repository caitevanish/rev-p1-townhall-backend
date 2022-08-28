package dev.evanishyn.app;

import com.google.gson.Gson;
import dev.evanishyn.daos.complaintDAOs.ComplaintDAOPostgres;
import dev.evanishyn.daos.meetingDAOs.MeetingDAOPostgres;
import dev.evanishyn.daos.userDAOS.UserDaoPostgres;
import dev.evanishyn.dtos.LoginCredentials;
import dev.evanishyn.entities.User;
import dev.evanishyn.handlers.complaint.*;
import dev.evanishyn.handlers.meeting.CreateNewMeetingHandler;
import dev.evanishyn.handlers.meeting.GetAllMeetingsHandler;
import dev.evanishyn.handlers.meeting.GetMeetingByIdHandler;
import dev.evanishyn.services.ComplaintServiceImpl;
import dev.evanishyn.services.LoginServiceImpl;
import dev.evanishyn.services.MeetingServiceImpl;
import dev.evanishyn.services.interfaces.ComplaintService;
import dev.evanishyn.services.interfaces.LoginService;
import dev.evanishyn.services.interfaces.MeetingService;
import io.javalin.Javalin;
import io.javalin.core.JavalinConfig;
import io.javalin.http.Handler;

public class App {

    public static ComplaintService complaintService = new ComplaintServiceImpl(new ComplaintDAOPostgres());
    public static MeetingService meetingService = new MeetingServiceImpl(new MeetingDAOPostgres());
    public static LoginService loginService = new LoginServiceImpl(new UserDaoPostgres());

    public static void main(String[] args) {
        Javalin app = Javalin.create(config->{  //Statement lambda can be replaced with expression lambda
            config.enableDevLogging();
            config.enableCorsForAllOrigins();   //Lambda can be replaced with method reference
        });
        //wrap a try-with resources statement


        //-----------Account User/Login-----------
        app.post("/login", ctx ->{
            String body = ctx.body();
            Gson gson = new Gson();
            LoginCredentials credentials = gson.fromJson(body, LoginCredentials.class);

            User user = loginService.validateUser(credentials.getUsername(), credentials.getPassword());
            String userJSON = gson.toJson(user);
            ctx.result(userJSON);
        });


        //-----------Complaint-----------
        CreateNewComplaintHandler createNewComplaintHandler = new CreateNewComplaintHandler();
        GetAllComplaintsHandler getAllComplaintsHandler = new GetAllComplaintsHandler();
        GetComplaintByIdHandler getComplaintByIdHandler = new GetComplaintByIdHandler();
        //Form:
        UpdateComplaintFormHandler updateComplaintFormHandler = new UpdateComplaintFormHandler();
        //[Status]
        UpdateComplaintStatusHandler updateComplaintStatusHandler = new UpdateComplaintStatusHandler();
        //[Status]
        UpdateComplaintPriorityHandler updateComplaintPriorityHandler = new UpdateComplaintPriorityHandler();
        //[Meeting]
        UpdateComplaintWithMeetingIdHandler updateComplaintWithMeetingIdHandler = new UpdateComplaintWithMeetingIdHandler();

        app.post("/complaints", createNewComplaintHandler);
        app.get("/complaints", getAllComplaintsHandler);
        app.get("/complaints/{id}", getComplaintByIdHandler);

        //Form
        app.put("/complaints/{id}", updateComplaintFormHandler);

        //[Status]
        app.put("/complaints/{id}/{status}", updateComplaintStatusHandler);
        //[Status]
        app.put("/complaints/{id}/{priority}", updateComplaintPriorityHandler);
        //[Meeting]
        app.put("/complaints/{id}/meeting/{mid}", updateComplaintWithMeetingIdHandler);

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

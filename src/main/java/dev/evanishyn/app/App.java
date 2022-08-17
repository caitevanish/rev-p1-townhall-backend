package dev.evanishyn.app;

import dev.evanishyn.daos.complaintDAOs.ComplaintDAOPostgres;
import dev.evanishyn.handlers.complaints.CreateNewComplaintHandler;
import dev.evanishyn.services.ComplaintServiceImpl;
import dev.evanishyn.services.interfaces.ComplaintService;
import io.javalin.Javalin;

public class App {

    public static ComplaintService complaintService = new ComplaintServiceImpl(new ComplaintDAOPostgres());

    public static void main(String[] args) {
        Javalin app = Javalin.create();

        //create config
        Javalin.create(config->{

            config.enableCorsForAllOrigins();
        });


        //-----------Account User-----------



        //-----------Complaint-----------
        CreateNewComplaintHandler createNewComplaintHandler = new CreateNewComplaintHandler();



        app.post("/complaints", createNewComplaintHandler);


        //-----------Meeting-----------



        app.start();
    }
}

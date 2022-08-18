package dev.evanishyn.handlers.complaint;

import com.google.gson.Gson;
import dev.evanishyn.app.App;
import dev.evanishyn.entities.Complaint;
import dev.evanishyn.entities.Meeting;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class GetAllComplaintsHandler implements Handler {
    public void handle(@NotNull Context ctx) throws Exception{
        List<Complaint> complaintList = App.complaintService.getAllComplaints();

        if(complaintList != null){
            Gson gson = new Gson();
            String json = gson.toJson(complaintList);

            ctx.status(200);    //Don't ever put in 204
            ctx.result("Here are all the complaints:\n" + json);

        } else{
            ctx.status(404);
            ctx.result("Error in retrieving complaint list.");
        }

    }
}

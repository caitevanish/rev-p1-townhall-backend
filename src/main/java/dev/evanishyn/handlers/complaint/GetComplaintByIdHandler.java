package dev.evanishyn.handlers.complaint;

import com.google.gson.Gson;
import dev.evanishyn.app.App;
import dev.evanishyn.entities.Complaint;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

public class GetComplaintByIdHandler implements Handler {

    @Override
    public void handle(@NotNull Context ctx) throws Exception {
        int id = Integer.parseInt(ctx.pathParam("id"));
        Complaint complaint = App.complaintService.getComplaintById(id);

        if(complaint != null){
            Gson gson = new Gson();
            String json = gson.toJson(complaint);
            ctx.status(200);
            ctx.result(json);
        }
        else{
            ctx.status(404);
            ctx.result("Error in retrieving complaint by id "+ complaint.getComplaint_id());
        }
    }
}

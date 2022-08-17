package dev.evanishyn.handlers.complaint;

import com.google.gson.Gson;
import dev.evanishyn.app.App;
import dev.evanishyn.entities.Complaint;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

public class CreateNewComplaintHandler implements Handler {

    public void handle(@NotNull Context ctx) throws Exception{
    String json = ctx.body();
    Gson gson = new Gson();
    Complaint complaint = gson.fromJson(json, Complaint.class);
    Complaint newComplaint = App.complaintService.createComplaint(complaint);
    String newJson = gson.toJson(newComplaint);

    ctx.status(201);
    ctx.result("Complaint has been submitted: \n" + newJson);
}
//throw an exception
}

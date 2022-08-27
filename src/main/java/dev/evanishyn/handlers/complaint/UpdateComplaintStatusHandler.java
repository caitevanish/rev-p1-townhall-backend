package dev.evanishyn.handlers.complaint;

import dev.evanishyn.app.App;
import dev.evanishyn.utilities.enums.Status;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

public class UpdateComplaintStatusHandler implements Handler {
    @Override
    public void handle(@NotNull Context ctx) throws Exception {
        int id = Integer.parseInt(ctx.pathParam("id"));
        String status = ctx.pathParam("status");

        if(App.complaintService.getComplaintById(id) != null ){
            App.complaintService.updateComplaintStatus(App.complaintService.getComplaintById(id), Status.valueOf(status));
            ctx.status(204);
            ctx.result("The complaint status has been updated to " + status);
        } else{
            ctx.status(404);
            ctx.result("Complaint status was not updated.");
        }

    }
}

package dev.evanishyn.handlers.complaint;

import dev.evanishyn.app.App;
import dev.evanishyn.utilities.enums.Priority;
import dev.evanishyn.utilities.enums.Status;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

public class UpdateComplaintPriorityHandler implements Handler
{
    @Override
    public void handle(@NotNull Context ctx) throws Exception {
        int id = Integer.parseInt(ctx.pathParam("id"));
        String priority = ctx.pathParam("priority");

        if(App.complaintService.getComplaintById(id) != null ){
            App.complaintService.updateComplaintPriority(App.complaintService.getComplaintById(id), Priority.valueOf(priority));
            ctx.status(204);
            ctx.result("The complaint priority has been updated to " + priority);
        } else{
            ctx.status(404);
            ctx.result("Complaint priority was not updated.");
        }
    }
}

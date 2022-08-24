package dev.evanishyn.handlers.complaint;

import dev.evanishyn.app.App;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

public class UpdateComplaintWithMeetingIdHandler implements Handler {


    @Override
    public void handle(@NotNull Context ctx) throws Exception {
        int id = Integer.parseInt(ctx.pathParam("id"));
        int meetingId = Integer.parseInt(ctx.pathParam("mid"));

        if (App.complaintService.getComplaintById(id) != null || App.meetingService.getMeetingById(meetingId) != null) {

            App.complaintService.updateComplaintWithMeetingId(App.complaintService.getComplaintById(id), meetingId);
            ctx.result("The complaint has been assigned to a meeting");
        } else{
            ctx.status(404);
            ctx.result("Complaint was not assigned a meeting(no meeting associated with ID)");
        }
    }
}

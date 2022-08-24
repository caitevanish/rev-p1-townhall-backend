package dev.evanishyn.handlers.meeting;

import com.google.gson.Gson;
import dev.evanishyn.app.App;
import dev.evanishyn.entities.Meeting;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

public class GetMeetingByIdHandler implements Handler {
    @Override
    public void handle(@NotNull Context ctx) throws Exception {
        int id = Integer.parseInt(ctx.pathParam("id"));
        Meeting meeting = App.meetingService.getMeetingById(id);

        if(meeting != null){
            Gson gson = new Gson();
            String json = gson.toJson(meeting);
            ctx.status(200);
            ctx.result(json);
        }
        else{
            ctx.status(404);
            ctx.result("Error in retrieving meeting by id "+ meeting.getMeetId());
        }
    }
}

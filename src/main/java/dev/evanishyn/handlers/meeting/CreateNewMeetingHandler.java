package dev.evanishyn.handlers.meeting;

import com.google.gson.Gson;
import dev.evanishyn.app.App;
import dev.evanishyn.entities.Meeting;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;



public class CreateNewMeetingHandler implements Handler {

    public void handle(@NotNull Context ctx) throws Exception{
        String json = ctx.body();
        Gson gson = new Gson();
        Meeting meeting = gson.fromJson(json, Meeting.class);
        Meeting newMeeting = App.meetingService.createMeeting(meeting);
        String newJson = gson.toJson(newMeeting);

        ctx.status(201);
        ctx.result("Meeting has been schedule: \n" + newJson);
    }
        //throw an exception

}

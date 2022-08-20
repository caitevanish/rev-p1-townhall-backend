package dev.evanishyn.handlers.meeting;

import com.google.gson.Gson;
import dev.evanishyn.app.App;
import dev.evanishyn.entities.Meeting;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class GetAllMeetingsHandler implements Handler {

    public void handle(@NotNull Context ctx) throws Exception{
        List<Meeting> meetingList = App.meetingService.getAllMeetings();

        if(meetingList != null){
        Gson gson = new Gson();
        String json = gson.toJson(meetingList);

        ctx.status(200);    //Don't ever put in 204
//        ctx.result("Here are all the meetings:\n" + json);
        ctx.result(json);

        } else{
            ctx.status(404);
            ctx.result("Error in retrieving meeting list.");
        }

    }

}

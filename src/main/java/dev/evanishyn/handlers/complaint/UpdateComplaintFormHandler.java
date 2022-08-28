package dev.evanishyn.handlers.complaint;

import com.google.gson.Gson;
import dev.evanishyn.app.App;
import dev.evanishyn.entities.Complaint;
import dev.evanishyn.utilities.enums.Priority;
import dev.evanishyn.utilities.enums.Status;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

public class UpdateComplaintFormHandler implements Handler {

    @Override
    public void handle(@NotNull Context ctx) throws Exception {
        int id = Integer.parseInt(ctx.pathParam("id"));
        Complaint complaint = App.complaintService.getComplaintById(id);
        if(complaint != null){
            String json = ctx.body();
            Gson gson = new Gson();
            Complaint preUpdate = gson.fromJson(json, Complaint.class);
            preUpdate.setComplaintId(id);
            Complaint updateComplaint = App.complaintService.updateComplaintForm(preUpdate);
            String json2 = gson.toJson(updateComplaint);
            ctx.status(204);
            ctx.result(json2);
        } else{
            ctx.status(404);
            ctx.result("Complaint not Found with ID: " + id);
        }




//        Complaint updatedComplaint = App.complaintService.updateComplaintForm(complaint);
//        String updateJson = gson.toJson(updatedComplaint);
//        ctx.result(updateJson);

//
//
//
//            if(updatedComplaint != null){
//                App.complaintService.updateComplaintForm(complaint);

//            if(complaint.getComplaintId()== id){
//            if(complaint.getComplaintId()!= id) {
//                ctx.status(404);
//                ctx.result("Something went wrong. Could not update complaint");
//            }
////            } else{
////            }
//
//        }
//        else{
//            ctx.status(404);
//            ctx.result("Complaint not Found with ID: " + id);
//        }

    }
}
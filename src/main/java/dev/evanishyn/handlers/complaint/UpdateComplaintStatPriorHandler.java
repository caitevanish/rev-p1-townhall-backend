//package dev.evanishyn.handlers.complaint;
//
//import com.google.gson.Gson;
//import dev.evanishyn.app.App;
//import dev.evanishyn.entities.Complaint;
//import dev.evanishyn.utilities.enums.Priority;
//import dev.evanishyn.utilities.enums.Status;
//import io.javalin.http.Context;
//import io.javalin.http.Handler;
//import org.jetbrains.annotations.NotNull;
//
//public class UpdateComplaintStatPriorHandler implements Handler {
//
//    @Override
//    public void handle(@NotNull Context ctx) throws Exception {
//        int complaintId = Integer.parseInt(ctx.pathParam("id"));
//        String status = ctx.pathParam("status");
//        String priority = ctx.pathParam("priority");
//
//
////        String complaintJSON = ctx.body();
//        Gson gson = new Gson();
////        Complaint complaint = gson.fromJson(complaintJSON, Complaint.class);
//        Complaint updateComplaint = App.complaintService.getComplaintById(complaintId);
////        String json = gson.toJson(updateComplaint);
//        updateComplaint = App.complaintService.updateComplaintDetails(updateComplaint, Status.valueOf(status), Priority.valueOf(priority));
//
////        String newJson = gson.toJson(updateComplaint);
//        if(updateComplaint!=null){
//            ctx.status(200);
//            ctx.result("Complaint has been updated");
//        } else {
//            ctx.status(404);
//            ctx.result("Complaint Details not found");
//        }
//
//
//
//
////        Complaint complaint = App.complaintService.getComplaintById(complaintId);
////        Complaint complaint = App.complaintService.updateComplaintDetails(complaint, status.name(), priority);
////        String json = gson.toJson(complaint);
////        if (complaint != null) {
////            ctx.status(200);
////            ctx.result(json);
////        }
//
//
////        if(complaint != null){
////            if(complaint.getStatus().name().equals("PENDING")){
////                if(status.equals("approved")){
////                    complaint = App.complaintService.updateComplaintDetails(complaint, Status.APPROVED, complaint.getPriority());
////                    String newJson = gson.toJson(complaint);
////                    ctx.status(200);
//////                    ctx.result(newJson);
////                }else if(status.equals("denied")){
////                    complaint = App.complaintService.updateComplaintDetails(complaint, Status.DENIED, complaint.getPriority());
////                    String newJson = gson.toJson(complaint);
////                    ctx.status(200);
////                }else{
////                    ctx.status(400);
////                    ctx.result("Incorrect route name");
////                }
////            } if(complaint.getPriority().name().equals("TBD"))
//
//    }
//}

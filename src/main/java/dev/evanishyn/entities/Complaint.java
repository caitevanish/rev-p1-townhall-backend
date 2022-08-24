package dev.evanishyn.entities;

import dev.evanishyn.utilities.enums.Priority;
import dev.evanishyn.utilities.enums.Status;

public class Complaint {
    private int complaintId;
    private String description;
    private Status status;
    private Priority priority;
    private int mId;  //need to get the meetingId...somehow

    public Complaint(int complaintId, String description, Status status, Priority priority, int mId) {
        this.complaintId = complaintId;
        this.description = description;
        this.status = status;
        this.priority = priority;
        this.mId = mId;
    }

    public Complaint() {

    }

    public int getComplaintId() {
        return complaintId;
    }

    public void setComplaintId(int complaintId) {
        this.complaintId = complaintId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    @Override
    public String toString() {
        return "Complaint{" +
                "complaintid=" + complaintId +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", priority=" + priority +
                ", mid=" + mId +
                '}';
    }
}

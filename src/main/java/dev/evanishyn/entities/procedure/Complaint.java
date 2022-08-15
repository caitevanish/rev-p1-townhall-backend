package dev.evanishyn.entities.procedure;

import dev.evanishyn.utilities.Status.Status;

public class Complaint {
    private int id;
    private int constitId;
    private int councilMemId;
    private String description;
    private Status status;
    private int meetingId;  //need to get the meetingId...somehow


    public Complaint(int id, int constitId, int councilMemId, String description, Status status, int meetingId) {
        this.id = id;
        this.constitId = constitId;
        this.councilMemId = councilMemId;
        this.description = description;
        this.status = status;
        this.meetingId = meetingId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getConstitId() {
        return constitId;
    }

    public void setConstitId(int constitId) {
        this.constitId = constitId;
    }

    public int getCouncilMemId() {
        return councilMemId;
    }

    public void setCouncilMemId(int councilMemId) {
        this.councilMemId = councilMemId;
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

    public int getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(int meetingId) {
        this.meetingId = meetingId;
    }

    @Override
    public String toString() {
        return "Complaint{" +
                "id=" + id +
                ", constitId=" + constitId +
                ", councilMemId=" + councilMemId +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", meetingId=" + meetingId +
                '}';
    }
}

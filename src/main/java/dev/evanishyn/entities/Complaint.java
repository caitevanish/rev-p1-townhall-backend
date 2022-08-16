package dev.evanishyn.entities;

import dev.evanishyn.utilities.enums.Priority;
import dev.evanishyn.utilities.enums.Status;

public class Complaint {
    private int id;
    private String description;
    private Status status;
    private Priority priority;
    private int meet_id;  //need to get the meetingId...somehow

    public Complaint(int id, String description, Status status, Priority priority, int meet_id) {
        this.id = id;
        this.description = description;
        this.status = status;
        this.priority = priority;
        this.meet_id = meet_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getMeet_id() {
        return meet_id;
    }

    public void setMeet_id(int meet_id) {
        this.meet_id = meet_id;
    }

    @Override
    public String toString() {
        return "Complaint{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", priority=" + priority +
                ", meet_id=" + meet_id +
                '}';
    }
}

package dev.evanishyn.entities;

import dev.evanishyn.utilities.enums.Priority;
import dev.evanishyn.utilities.enums.Status;

public class Complaint {
    private int complaint_id;
    private String description;
    private Status status;
    private Priority priority;
    private int m_id;  //need to get the meetingId...somehow

    public Complaint(int complaint_id, String description, Status status, Priority priority, int m_id) {
        this.complaint_id = complaint_id;
        this.description = description;
        this.status = status;
        this.priority = priority;
        this.m_id = m_id;
    }

    public Complaint() {

    }

    public int getComplaint_id() {
        return complaint_id;
    }

    public void setComplaint_id(int complaint_id) {
        this.complaint_id = complaint_id;
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

    public int getM_id() {
        return m_id;
    }

    public void setM_id(int m_id) {
        this.m_id = m_id;
    }

    @Override
    public String toString() {
        return "Complaint{" +
                "complaint_id=" + complaint_id +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", priority=" + priority +
                ", m_id=" + m_id +
                '}';
    }
}

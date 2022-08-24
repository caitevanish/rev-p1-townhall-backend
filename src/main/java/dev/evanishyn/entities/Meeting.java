package dev.evanishyn.entities;

public class Meeting {
    private int meetId;
    private int time;
    private String location;
    private String summary;


    public Meeting(int meetId, int time, String location, String summary) {
        this.meetId = meetId;
        this.time = time;
        this.location = location;
        this.summary = summary;
    }

    public Meeting() {

    }

    public int getMeetId() {
        return meetId;
    }

    public void setMeetId(int meetId) {
        this.meetId = meetId;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Override
    public String toString() {
        return "Meeting{" +
                "meetId=" + meetId +
                ", time=" + time +
                ", location='" + location + '\'' +
                ", summary='" + summary + '\'' +
                '}';
    }
}

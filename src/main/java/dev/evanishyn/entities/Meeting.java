package dev.evanishyn.entities;

public class Meeting {
    private int meet_id;
    private int time;
    private String location;
    private String summary;


    public Meeting(int meet_id, int time, String location, String summary) {
        this.meet_id = meet_id;
        this.time = time;
        this.location = location;
        this.summary = summary;
    }

    public Meeting() {

    }

    public int getMeet_id() {
        return meet_id;
    }

    public void setMeet_id(int meet_id) {
        this.meet_id = meet_id;
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
                "meet_id=" + meet_id +
                ", time=" + time +
                ", location='" + location + '\'' +
                ", summary='" + summary + '\'' +
                '}';
    }
}

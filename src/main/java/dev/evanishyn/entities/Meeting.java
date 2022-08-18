package dev.evanishyn.entities;

public class Meeting {
    private int id;
    private int time;
    private String location;
    private String summary;


    public Meeting(int id, int time, String location, String summary) {
        this.id = id;
        this.time = time;
        this.location = location;
        this.summary = summary;
    }

    public Meeting() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
                "id=" + id +
                ", time=" + time +
                ", location='" + location + '\'' +
                ", summary='" + summary + '\'' +
                '}';
    }
}

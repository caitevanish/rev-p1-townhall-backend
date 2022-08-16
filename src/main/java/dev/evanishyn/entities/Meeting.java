package dev.evanishyn.entities;

public class Meeting {
    private int id;
    private int meet_time;
    private String location;

    public Meeting(int id, int meet_time, String location) {
        this.id = id;
        this.meet_time = meet_time;
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMeet_time() {
        return meet_time;
    }

    public void setMeet_time(int meet_time) {
        this.meet_time = meet_time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Meeting{" +
                "id=" + id +
                ", meet_time=" + meet_time +
                ", location='" + location + '\'' +
                '}';
    }
}

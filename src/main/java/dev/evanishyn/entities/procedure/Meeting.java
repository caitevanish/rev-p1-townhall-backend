package dev.evanishyn.entities.procedure;

public class Meeting {
    private int id;
    private long date;
    private String time;
    private int councilMemId;

    public Meeting(int id, long date, String time, int councilMemId) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.councilMemId = councilMemId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getCouncilMemId() {
        return councilMemId;
    }

    public void setCouncilMemId(int councilMemId) {
        this.councilMemId = councilMemId;
    }

    @Override
    public String toString() {
        return "Meeting{" +
                "id=" + id +
                ", date=" + date +
                ", time='" + time + '\'' +
                ", councilMemId=" + councilMemId +
                '}';
    }
}

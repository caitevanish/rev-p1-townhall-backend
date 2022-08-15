package dev.evanishyn.entities.user;

public class CouncilMember extends User {

    private int councilMemId;
    private String title;

    //Inheriting from User: id, fname, lname, username, password


    public CouncilMember(int id, String username, String password, String fName, String lName, int councilMemId, String title) {
        super(id, username, password, fName, lName);
        this.councilMemId = councilMemId;
        this.title = title;
    }

    public Integer getCouncilMemId() {
        return councilMemId;
    }

    public void setCouncilMemId(Integer councilMemId) {
        this.councilMemId = councilMemId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "CouncilMember{" +
                "id='" + getId() + '\'' +
                ", username='" + getUsername() + '\'' +
                ", password='" + getPassword() + '\'' +
                ", fName='" + getfName() + '\'' +
                ", lName='" + getlName() + '\'' +
                ", councilMemId='" + councilMemId + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}

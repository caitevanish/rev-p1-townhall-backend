package dev.evanishyn.entities.user;

public class Constituent extends User{

    private Integer constitId;
    private boolean isRegistered;

    //Inheriting from User: id, fname, lname, username, password

    public Integer getConstitId() {
        return constitId;
    }

    public void setConstitId(Integer constitId) {
        this.constitId = constitId;
    }

    public boolean isRegistered() {
        return isRegistered;
    }

    public void setRegistered(boolean registered) {
        isRegistered = registered;
    }

    @Override
    public String toString() {
        return "Constituent{" +
                "id='" + getId() + '\'' +
                ", username='" + getUsername() + '\'' +
                ", password='" + getPassword() + '\'' +
                ", fName='" + getfName() + '\'' +
                ", lName='" + getlName() + '\'' +
                ", constitId=" + constitId +
                ", isRegistered=" + isRegistered +
                '}';
    }
}

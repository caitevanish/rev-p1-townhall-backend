package dev.evanishyn.entities.user;

public class Constituent extends User{

    private int constitId;
    private boolean isRegistered;

    //Inheriting from User: id, fname, lname, username, password


    public Constituent(int id, String username, String password, String fName, String lName, int constitId, boolean isRegistered) {
        super(id, username, password, fName, lName);
        this.constitId = constitId;
        this.isRegistered = isRegistered;
    }

    public int getConstitId() {
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

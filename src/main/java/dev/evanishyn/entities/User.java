package dev.evanishyn.entities;

import dev.evanishyn.utilities.enums.AcctType;

public class User {
    private int userId;
    private String username;
    private String password;
    private String fName;
    private String lName;

    private AcctType acctType;


    public User(){

    }

    public User(int userId, String username, String password, String fName, String lName, AcctType acctType) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.fName = fName;
        this.lName = lName;
        this.acctType = acctType;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public AcctType getAcctType() {
        return acctType;
    }

    public void setAcctType(AcctType acctType) {
        this.acctType = acctType;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", accttype=" + acctType +
                '}';
    }
}

package com.zf.pojo;

public class GuihuanRecord {
    String username;
    String carname;
    String date;

    public GuihuanRecord() {
    }

    public GuihuanRecord(String username, String carname, String date) {
        this.username = username;
        this.carname = carname;
        this.date = date;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCarname() {
        return carname;
    }

    public void setCarname(String carname) {
        this.carname = carname;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Record{" +
                "username='" + username + '\'' +
                ", carname='" + carname + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}

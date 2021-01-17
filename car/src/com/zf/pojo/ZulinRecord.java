package com.zf.pojo;

public class ZulinRecord {
    String username;
    String carname;
    String date;
    int days;
    Double totalprice;
    String state = "租赁未归还";

    public ZulinRecord() {
    }

    public ZulinRecord(String username, String carname, String date, int days, Double totalprice, String state) {
        this.username = username;
        this.carname = carname;
        this.date = date;
        this.days = days;
        this.totalprice = totalprice;
        if(state!=null&&!"".equals(state))
            this.state = state;
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

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public Double getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(Double totalprice) {
        this.totalprice = totalprice;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        if(state!=null&&!"".equals(state))
            this.state = state;
    }

    @Override
    public String toString() {
        return "ZulinRecord{" +
                "username='" + username + '\'' +
                ", carname='" + carname + '\'' +
                ", date='" + date + '\'' +
                ", days='" + days + '\'' +
                ", totalprice=" + totalprice +
                ", state='" + state + '\'' +
                '}';
    }
}

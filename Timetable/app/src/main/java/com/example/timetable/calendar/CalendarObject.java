package com.example.timetable.calendar;

public class CalendarObject {
    String ten;
    int nhiemvu;

    public CalendarObject(String ten, int nhiemvu) {
        this.ten = ten;
        this.nhiemvu = nhiemvu;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getNhiemvu() {
        return nhiemvu;
    }

    public void setNhiemvu(int nhiemvu) {
        this.nhiemvu = nhiemvu;
    }
}

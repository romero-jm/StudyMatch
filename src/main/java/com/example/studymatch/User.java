package com.example.studymatch;

public class User {
    String IDNum;
    String name;
    String courseID;
    String lesson;
    String contact;
    String mode;

    public User(String name, String IDNum, String courseID, String lesson, String mode, String contact) {
        this.IDNum = name;
        this.name = IDNum;
        this.courseID = courseID;
        this.lesson = lesson;
        this.mode = mode;
        this.contact = contact;
    }

    public String getLesson() {
        return lesson;
    }

    public void setLesson(String lesson) {
        this.lesson = lesson;
    }

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public String getIDNum() {
        return IDNum;
    }

    public void setIDNum(String IDNum) {
        this.IDNum = IDNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "User{" +
                "IDNum='" + IDNum + '\'' +
                ", name='" + name + '\'' +
                ", courseID='" + courseID + '\'' +
                ", lesson='" + lesson + '\'' +
                ", contact='" + contact + '\'' +
                ", mode='" + mode + '\'' +
                '}';
    }
}

package com.example.studymatch;

public class User {
    String name;
    String IDNum;
    String courseID;
    String lesson;

    public User(String name, String IDNum, String courseID, String lesson) {
        this.name = name;
        this.IDNum = IDNum;
        this.courseID = courseID;
        this.lesson = lesson;
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
}

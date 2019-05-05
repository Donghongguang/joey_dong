package com.dancer.entity;

import java.util.Date;

public class TLesson {
    private String lessonid;

    private String lessonname;

    private Date lessontime;

    private Float lessonprice;

    private Integer lessonstatus;

    private Integer lessontypeid;

    private String lessonurl;

    public String getLessonid() {
        return lessonid;
    }

    public void setLessonid(String lessonid) {
        this.lessonid = lessonid == null ? null : lessonid.trim();
    }

    public String getLessonname() {
        return lessonname;
    }

    public void setLessonname(String lessonname) {
        this.lessonname = lessonname == null ? null : lessonname.trim();
    }

    public Date getLessontime() {
        return lessontime;
    }

    public void setLessontime(Date lessontime) {
        this.lessontime = lessontime;
    }

    public Float getLessonprice() {
        return lessonprice;
    }

    public void setLessonprice(Float lessonprice) {
        this.lessonprice = lessonprice;
    }

    public Integer getLessonstatus() {
        return lessonstatus;
    }

    public void setLessonstatus(Integer lessonstatus) {
        this.lessonstatus = lessonstatus;
    }

    public Integer getLessontypeid() {
        return lessontypeid;
    }

    public void setLessontypeid(Integer lessontypeid) {
        this.lessontypeid = lessontypeid;
    }

    public String getLessonurl() {
        return lessonurl;
    }

    public void setLessonurl(String lessonurl) {
        this.lessonurl = lessonurl == null ? null : lessonurl.trim();
    }
}
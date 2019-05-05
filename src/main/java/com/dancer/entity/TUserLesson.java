package com.dancer.entity;

public class TUserLesson {
    private Integer tulid;

    private Integer userid;

    private String lessonid;

    private Integer useraction;

    public Integer getTulid() {
        return tulid;
    }

    public void setTulid(Integer tulid) {
        this.tulid = tulid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getLessonid() {
        return lessonid;
    }

    public void setLessonid(String lessonid) {
        this.lessonid = lessonid == null ? null : lessonid.trim();
    }

    public Integer getUseraction() {
        return useraction;
    }

    public void setUseraction(Integer useraction) {
        this.useraction = useraction;
    }
}
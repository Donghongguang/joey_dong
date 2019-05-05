package com.dancer.entity;

public class TAdminLesson {
    private Integer talid;

    private Integer adminid;

    private String lessonid;

    private Integer adminaction;

    public Integer getTalid() {
        return talid;
    }

    public void setTalid(Integer talid) {
        this.talid = talid;
    }

    public Integer getAdminid() {
        return adminid;
    }

    public void setAdminid(Integer adminid) {
        this.adminid = adminid;
    }

    public String getLessonid() {
        return lessonid;
    }

    public void setLessonid(String lessonid) {
        this.lessonid = lessonid == null ? null : lessonid.trim();
    }

    public Integer getAdminaction() {
        return adminaction;
    }

    public void setAdminaction(Integer adminaction) {
        this.adminaction = adminaction;
    }
}
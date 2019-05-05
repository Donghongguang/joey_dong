package com.dancer.entity;

public class TUserinfo {
    private Integer userid;

    public TUserinfo(Integer userid, String username, String password, String realname, Integer roleid, Float score, Float accountmoney, String sex, String age, String telephone, String address) {
        this.userid = userid;
        this.username = username;
        this.password = password;
        this.realname = realname;
        this.roleid = roleid;
        this.score = score;
        this.accountmoney = accountmoney;
        this.sex = sex;
        this.age = age;
        this.telephone = telephone;
        this.address = address;
    }

    private String username;

    private String password;

    private String realname;

    private Integer roleid;

    private Float score;

    private Float accountmoney;

    private String sex;

    private String age;

    private String telephone;
   public TUserinfo(){

   }
    public TUserinfo(String username, String password, String realname, Integer roleid, String sex, String age, String telephone, String address) {
        this.username = username;
        this.password = password;
        this.realname = realname;
        this.roleid = roleid;
        this.sex = sex;
        this.age = age;
        this.telephone = telephone;
        this.address = address;
    }

    private String address;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    public Float getAccountmoney() {
        return accountmoney;
    }

    public void setAccountmoney(Float accountmoney) {
        this.accountmoney = accountmoney;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age == null ? null : age.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }
}
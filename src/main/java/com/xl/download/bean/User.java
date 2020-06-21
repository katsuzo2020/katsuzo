package com.xl.download.bean;

public class User {
    private  int id;
    private  String name;
    private  String password;
    private  int Did;
    private  int isadmin;
    private  int age;
    private  String sex;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public int getDid() {
        return Did;
    }

    public int getIsadmin() {
        return isadmin;
    }

    public int getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDid(int did) {
        Did = did;
    }

    public void setIsadmin(int isadmin) {
        this.isadmin = isadmin;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}

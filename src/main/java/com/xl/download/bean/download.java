package com.xl.download.bean;

import java.util.Date;

public class download {
    private int id;
    //软件的名称
    private String software_name;
    //软件的类型名
    private String software_type;
    //软件的地址
    private String software_url;
    //对软件的描述
    private String Specification;
    //区分软件的类型id
    private int cid;
    private User user;
    private String software_image;
    private int userid;
    private Date date;
    private category category;

    public com.xl.download.bean.category getCategory() {
        return category;
    }

    public void setCategory(com.xl.download.bean.category category) {
        this.category = category;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public String getSoftware_name() {
        return software_name;
    }

    public String getSoftware_type() {
        return software_type;
    }

    public String getSoftware_url() {
        return software_url;
    }

    public String getSpecification() {
        return Specification;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSoftware_image() {
        return software_image;
    }

    public void setSoftware_image(String software_image) {
        this.software_image = software_image;
    }

    public void setSoftware_name(String software_name) {
        this.software_name = software_name;
    }

    public void setSoftware_type(String software_type) {
        this.software_type = software_type;
    }

    public void setSoftware_url(String software_url) {
        this.software_url = software_url;
    }

    public void setSpecification(String specification) {
        Specification = specification;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "download{" +
                "id=" + id +
                ", software_name='" + software_name + '\'' +
                ", software_type='" + software_type + '\'' +
                ", software_url='" + software_url + '\'' +
                ", Specification='" + Specification + '\'' +
                ", cid=" + cid +
                ", user=" + user +
                ", software_image='" + software_image + '\'' +
                ", date=" + date +
                ", category=" + category +
                '}';
    }
}

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
    private category category;
    private String software_imge;
    private  Date date;
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

    public category getCategory() {
        return category;
    }

    public void setCategory(category category) {
        this.category = category;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getSoftware_imge() {
        return software_imge;
    }

    public void setSoftware_imge(String software_imge) {
        this.software_imge = software_imge;
    }

}

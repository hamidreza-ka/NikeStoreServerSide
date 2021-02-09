package com.hrk.nikestore.modules.banner.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Banner {

    @Id
    private Long id;
    private String image;
    private int link_type;
    private String link_value;


    public Banner() {
    }

    public Banner(Long id, String image, int link_type, String link_value) {
        this.id = id;
        this.image = image;
        this.link_type = link_type;
        this.link_value = link_value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getLink_type() {
        return link_type;
    }

    public void setLink_type(int link_type) {
        this.link_type = link_type;
    }

    public String getLink_value() {
        return link_value;
    }

    public void setLink_value(String link_value) {
        this.link_value = link_value;
    }
}

package com.jspring1.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MusicGroup {

    // автоматическое добавление уникального айдишника
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public String id;

    public String name, style, country;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    public MusicGroup() {}

    public MusicGroup(String name, String style, String country) {
        this.name = name;
        this.style = style;
        this.country = country;
    }
}

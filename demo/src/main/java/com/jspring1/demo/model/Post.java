package com.jspring1.demo.model;

//интерфейс нужен для манипуляции таблицами из моделей


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//Аннотация которая говорит, что класс Пост это модель
@Entity
public class Post {

    // автоматическое добавление уникального айдишника
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public String id;

    public String title, anons, full_text;
    public int views;

    //геттеры сеттеры

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAnons() {
        return anons;
    }

    public void setAnons(String anons) {
        this.anons = anons;
    }

    public String getFull_text() {
        return full_text;
    }

    public void setFull_text(String full_text) {
        this.full_text = full_text;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    // выяснить
    public Post() {
    }

    //конструктор
    public Post(String title, String anons, String full_text) {
        this.title = title;
        this.anons = anons;
        this.full_text = full_text;
    }

}



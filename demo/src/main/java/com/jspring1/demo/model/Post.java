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

    public String title, preview, content;
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

    public String getpreview() {
        return preview;
    }

    public void setpreview(String preview) {
        this.preview = preview;
    }

    public String getcontent() {
        return content;
    }

    public void setcontent(String content) {
        this.content = content;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }


    public Post() {
    }

    //конструктор
    public Post(String title, String preview, String content) {
        this.title = title;
        this.preview = preview;
        this.content = content;
    }

}



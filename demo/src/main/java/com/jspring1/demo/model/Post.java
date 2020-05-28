package com.jspring1.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@Entity // класс Пост это модель
public class Post {

    // автоматическое добавление уникального айдишника
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public String id;

    public String title, content, preview;
    public int views;


    //конструктор
    public Post(String title, String preview, String content) {
        this.title = title;
        this.preview = preview;
        this.content = content;
    }

}



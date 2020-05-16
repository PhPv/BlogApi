package com.jspring1.demo.nextLvlExceptions;
import lombok.*;

/*@Data //геттеры сеттеры
@NoArgsConstructor //пустой констр
@AllArgsConstructor //с параметрами
public class idExceptionConstructor {
    public int status;
    public String error, message;
}*/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionConstructor extends RuntimeException{
    private String code;
    private String type;
    private String message;
}
package com.jspring1.demo.nextLvlExceptions;
import lombok.NoArgsConstructor;


import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
//@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Post not found")
public class idException extends RuntimeException {
    private String id;







}

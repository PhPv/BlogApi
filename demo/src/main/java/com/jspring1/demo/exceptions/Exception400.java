package com.jspring1.demo.exceptions;

import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "ID is empty")
public class Exception400 extends RuntimeException {
    private String id;
}

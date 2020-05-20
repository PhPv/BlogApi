package com.jspring1.demo.exceptions;

import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Content not found")
public class Exception404 extends RuntimeException {
    private String id;
}

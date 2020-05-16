package com.jspring1.demo.nextLvlExceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/*@ControllerAdvice
public class AwesomeExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(idException.class)
    protected ResponseEntity<AwesomeException> handleThereIsNoSuchUserException() {

        return new ResponseEntity<>(new AwesomeException("Content not found"), HttpStatus.NOT_FOUND);
    }

    @Data
    @AllArgsConstructor
    private static class AwesomeException {
        private String message;
    }
}*/

@ControllerAdvice
@RestControllerAdvice
public class AwesomeExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(idException.class)
    public ResponseEntity<AwesomeExceptionHandler> handleApiException(idException ex) {
        ExceptionConstructor exception = new ExceptionConstructor();
        exception.setCode("error-000404");
        exception.setType(HttpStatus.NOT_FOUND.toString());
        exception.setMessage("Content not found: " + ex.getId());
        AwesomeExceptionHandler awesomeExceptionHandler = new AwesomeExceptionHandler();


        return new ResponseEntity<>(awesomeExceptionHandler, HttpStatus.NOT_FOUND);
    }
}
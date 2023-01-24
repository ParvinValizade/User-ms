package com.company.userms.exception.handler;

import com.company.userms.dto.response.ErrorResponse;
import com.company.userms.exception.UserAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(UserAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleCustomException(UserAlreadyExistsException e){
        return ErrorResponse.builder()
                .code(e.getCode().value())
                .description(e.getMessage())
                .build();
    }
}

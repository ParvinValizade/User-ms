package com.company.userms.exception;

import com.company.userms.enums.ErrorCodeEnum;
import org.springframework.http.HttpStatus;

public class UserAlreadyExistsException extends RuntimeException{

    private final HttpStatus code;
    private final String message;

    public UserAlreadyExistsException(ErrorCodeEnum errorCodeEnum) {
        super(errorCodeEnum.getMessage());
        this.message=errorCodeEnum.getMessage();
        this.code=errorCodeEnum.getCode();
    }

    public HttpStatus getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}

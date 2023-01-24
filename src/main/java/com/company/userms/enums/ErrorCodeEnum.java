package com.company.userms.enums;

import org.springframework.http.HttpStatus;

public enum ErrorCodeEnum {
    USER_ALREADY_EXISTS(HttpStatus.CONFLICT, "User already exists");

    private final HttpStatus code;
    private final String message;

    ErrorCodeEnum(HttpStatus code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getCode() {
        return code;
    }
}

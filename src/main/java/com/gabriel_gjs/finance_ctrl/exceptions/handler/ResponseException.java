package com.gabriel_gjs.finance_ctrl.exceptions.handler;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ResponseException {
    private int statusCode;
    private HttpStatus status;
    private String message;

    public ResponseException(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
        this.statusCode = status.value();
    }
}

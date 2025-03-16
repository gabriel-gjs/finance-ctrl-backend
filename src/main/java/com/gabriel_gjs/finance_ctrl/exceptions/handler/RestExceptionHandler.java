package com.gabriel_gjs.finance_ctrl.exceptions.handler;

import com.gabriel_gjs.finance_ctrl.exceptions.CPFAlreadyRegisteredException;
import com.gabriel_gjs.finance_ctrl.exceptions.EmailAlreadyRegisteredException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(CPFAlreadyRegisteredException.class)
    private ResponseEntity<ResponseException> cpfAlreadyRegisteredExceptionHandler(CPFAlreadyRegisteredException exception) {
        ResponseException responseException = new ResponseException(HttpStatus.BAD_REQUEST, exception.getMessage());
        return ResponseEntity.status(responseException.getStatus()).body(responseException);
    }

    @ExceptionHandler(EmailAlreadyRegisteredException.class)
    private ResponseEntity<ResponseException> emailAlreadyRegisteredExceptionHandler(EmailAlreadyRegisteredException exception) {
        ResponseException responseException = new ResponseException(HttpStatus.BAD_REQUEST, exception.getMessage());
        return ResponseEntity.status(responseException.getStatus()).body(responseException);
    }
}

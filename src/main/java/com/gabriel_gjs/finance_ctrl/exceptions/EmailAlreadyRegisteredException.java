package com.gabriel_gjs.finance_ctrl.exceptions;

public class EmailAlreadyRegisteredException extends RuntimeException {

    public EmailAlreadyRegisteredException () {
       super("E-mail já cadastrado");
    }

    public EmailAlreadyRegisteredException (String message) {
        super(message);
    }
}

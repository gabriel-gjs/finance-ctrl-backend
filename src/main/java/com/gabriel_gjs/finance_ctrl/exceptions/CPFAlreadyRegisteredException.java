package com.gabriel_gjs.finance_ctrl.exceptions;

public class CPFAlreadyRegisteredException extends RuntimeException{
    public CPFAlreadyRegisteredException () {
        super("CPF já cadastrado");
    }

    public CPFAlreadyRegisteredException (String message) {
        super(message);
    }
}

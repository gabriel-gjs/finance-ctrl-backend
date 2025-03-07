package com.gabriel_gjs.finance_ctrl.domain.entities.user.dtos;

public record UserCreateDTO(
        String name,
        String cpf,
        String birthdayDate,
        String email,
        String password
){}
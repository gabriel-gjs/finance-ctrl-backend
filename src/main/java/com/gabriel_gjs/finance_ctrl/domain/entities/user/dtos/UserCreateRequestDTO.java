package com.gabriel_gjs.finance_ctrl.domain.entities.user.dtos;

public record UserCreateRequestDTO(
        String name,
        String cpf,
        String birthdayDate,
        String email,
        String password
){}
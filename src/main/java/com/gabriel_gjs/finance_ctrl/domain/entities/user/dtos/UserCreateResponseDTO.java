package com.gabriel_gjs.finance_ctrl.domain.entities.user.dtos;

import java.util.Date;

public record UserCreateResponseDTO(
        Long id,
        String name,
        String cpf,
        Date birthdayDate,
        String email
) {}
package com.gabriel_gjs.finance_ctrl.domain.factories;

import com.gabriel_gjs.finance_ctrl.domain.entities.user.User;
import com.gabriel_gjs.finance_ctrl.domain.entities.user.dtos.UserCreateRequestDTO;
import com.gabriel_gjs.finance_ctrl.domain.entities.user.dtos.UserCreateResponseDTO;
import com.gabriel_gjs.finance_ctrl.domain.entities.user.enums.UserRole;
import com.gabriel_gjs.finance_ctrl.domain.entities.user.enums.UserStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UserFactory {

    public User generateUser(UserCreateRequestDTO data, String passwordHash) {
        User user = new User();

        user.setEmail(data.email());
        user.setPassword(passwordHash);
        user.setRole(UserRole.USER);
        user.setStatus(UserStatus.ACTIVE);

        log.info(user.toString());

        return user;
    }

    public UserCreateResponseDTO generateResponseUser(User user) {
        UserCreateResponseDTO UserCreateResponseDTO = new UserCreateResponseDTO(
                user.getId(),
                user.getPerson().getName(),
                user.getPerson().getCpf(),
                user.getPerson().getBirthdayDate(),
                user.getEmail()
        );

        log.info(UserCreateResponseDTO.toString());

        return UserCreateResponseDTO;
    }
}

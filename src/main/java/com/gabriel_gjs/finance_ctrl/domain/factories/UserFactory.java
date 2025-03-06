package com.gabriel_gjs.finance_ctrl.domain.factories;

import com.gabriel_gjs.finance_ctrl.domain.entities.user.User;
import com.gabriel_gjs.finance_ctrl.domain.entities.user.dtos.UserCreateDTO;
import com.gabriel_gjs.finance_ctrl.domain.entities.user.enums.UserRole;
import com.gabriel_gjs.finance_ctrl.domain.entities.user.enums.UserStatus;
import org.springframework.stereotype.Component;

@Component
public class UserFactory {

    public User generateUser(UserCreateDTO data, String passwordHash) {
        User user = new User();

        user.setEmail(data.email());
        user.setPassword(passwordHash);
        user.setRole(UserRole.USER);
        user.setStatus(UserStatus.ACTIVE);

        return user;
    }
}

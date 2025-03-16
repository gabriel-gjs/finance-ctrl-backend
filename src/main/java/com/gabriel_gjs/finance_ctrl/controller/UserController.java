package com.gabriel_gjs.finance_ctrl.controller;

import com.gabriel_gjs.finance_ctrl.domain.entities.person.Person;
import com.gabriel_gjs.finance_ctrl.domain.entities.user.User;
import com.gabriel_gjs.finance_ctrl.domain.entities.user.dtos.UserCreateRequestDTO;
import com.gabriel_gjs.finance_ctrl.domain.factories.PersonFactory;
import com.gabriel_gjs.finance_ctrl.domain.factories.UserFactory;
import com.gabriel_gjs.finance_ctrl.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserFactory userFactory;

    @Autowired
    private PersonFactory personFactory;

    @PostMapping("/user")
    public ResponseEntity createUser(@RequestBody UserCreateRequestDTO data) {
        log.info("Inicio de registro de usuário com seguinte body:");

        log.info((
                "Nome: ".concat(data.name()) +
                ", Data de aniversário: ".concat(data.birthdayDate())  +
                ", CPF: ".concat(data.cpf())  +
                ", E-mail: ".concat(data.email()) )
        );

        this.userService.validateCreateUser(data);

        String passwordHash = userService.encryptedPassword(data.password());

        User newUser =  this.userFactory.generateUser(data, passwordHash);
        Person newPerson = this.personFactory.generatePerson(data);

        User userSaved = this.userService.saveUser(newUser, newPerson);

        log.info("Usuário cadastrado com sucesso");

        return ResponseEntity.status(HttpStatus.CREATED).body(this.userFactory.generateResponseUser(userSaved));
    }
}

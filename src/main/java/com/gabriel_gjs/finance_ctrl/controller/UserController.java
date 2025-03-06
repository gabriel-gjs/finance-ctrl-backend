package com.gabriel_gjs.finance_ctrl.controller;

import com.gabriel_gjs.finance_ctrl.domain.entities.person.Person;
import com.gabriel_gjs.finance_ctrl.domain.entities.user.User;
import com.gabriel_gjs.finance_ctrl.domain.entities.user.dtos.UserCreateDTO;
import com.gabriel_gjs.finance_ctrl.domain.factories.PersonFactory;
import com.gabriel_gjs.finance_ctrl.domain.factories.UserFactory;
import com.gabriel_gjs.finance_ctrl.domain.repositories.PersonRepository;
import com.gabriel_gjs.finance_ctrl.domain.repositories.UserRepository;
import com.gabriel_gjs.finance_ctrl.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.ConnectionBuilder;

@RestController
@RequestMapping
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private UserFactory userFactory;

    @Autowired
    private PersonFactory personFactory;

    @PostMapping("/user")
    public ResponseEntity createUser(@RequestBody UserCreateDTO data) {
        log.info("Inicio de registro de usuário com seguinte body:");
        log.info(data.name(),data.birthdayDate(),data.cpf(),data.email());


        if(this.userRepository.findByEmail(data.email()) != null) {
            return ResponseEntity.badRequest().build();
        }

        if(this.personRepository.findByCpf(data.cpf()) != null) {
            return ResponseEntity.badRequest().build();
        }

        String passwordHash = userService.encryptedPassword(data.password());

        User newUser =  this.userFactory.generateUser(data, passwordHash);
        Person newPerson = this.personFactory.generatePerson(data);

        User userSaved = userService.saveUser(newUser, newPerson);

        return ResponseEntity.status(HttpStatus.CREATED).body(userSaved);
    }
}

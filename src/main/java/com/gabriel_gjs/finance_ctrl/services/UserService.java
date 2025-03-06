package com.gabriel_gjs.finance_ctrl.services;

import com.gabriel_gjs.finance_ctrl.domain.entities.person.Person;
import com.gabriel_gjs.finance_ctrl.domain.entities.user.User;
import com.gabriel_gjs.finance_ctrl.domain.repositories.PersonRepository;
import com.gabriel_gjs.finance_ctrl.domain.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PersonRepository personRepository;

    public String encryptedPassword(String password) {
        return new BCryptPasswordEncoder().encode(password);
    }

    @Transactional
    public User saveUser(User user, Person person) {
        log.info("inicio do registrar usuário");
        log.info(user.toString());
        log.info(person.toString());

        User newUser = this.userRepository.save(user);

        log.info("Usuario salvo");
        log.info(user.toString());
        log.info(person.toString());
        log.info(newUser.toString());

        person.setUser(newUser);

        log.info("Setado usuario no person");
        log.info(user.toString());
        log.info(person.toString());
        log.info(newUser.toString());

        this.personRepository.save(person);

        log.info("Person salvo com sucesso");
        log.info(user.toString());
        log.info(person.toString());
        log.info(newUser.toString());


        return newUser;
    }
}

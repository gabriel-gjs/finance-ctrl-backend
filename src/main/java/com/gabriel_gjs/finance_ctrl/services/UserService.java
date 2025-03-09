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
        User newUser = this.userRepository.save(user);

        person.setUser(newUser);

        newUser.setPerson(this.personRepository.save(person));

        return newUser;
    }
}

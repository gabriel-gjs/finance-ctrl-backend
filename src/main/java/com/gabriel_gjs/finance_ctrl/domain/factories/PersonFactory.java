package com.gabriel_gjs.finance_ctrl.domain.factories;


import com.gabriel_gjs.finance_ctrl.domain.entities.person.Person;
import com.gabriel_gjs.finance_ctrl.domain.entities.user.dtos.UserCreateRequestDTO;
import com.gabriel_gjs.finance_ctrl.util.Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PersonFactory {

    public Person generatePerson(UserCreateRequestDTO data) {
        Person person = new Person();

        person.setName(data.name());
        person.setCpf(data.cpf());
        person.setBirthdayDate(Util.generateDate(data.birthdayDate()));

        log.info(person.toString());

        return person;
    }
}

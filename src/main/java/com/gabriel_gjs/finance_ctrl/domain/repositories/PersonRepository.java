package com.gabriel_gjs.finance_ctrl.domain.repositories;

import com.gabriel_gjs.finance_ctrl.domain.entities.person.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
    Person findByCpf(String email);
}
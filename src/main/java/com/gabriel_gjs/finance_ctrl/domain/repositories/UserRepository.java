package com.gabriel_gjs.finance_ctrl.domain.repositories;

import com.gabriel_gjs.finance_ctrl.domain.entities.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {}
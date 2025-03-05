package com.gabriel_gjs.finance_ctrl.domain.entities.person;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Table(name = "pessoa")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    private String name;

    @Column(name = "cpf", unique = true)
    private String cpf;

    @Column(name = "senha")
    private Date birthdayDate;

    @CreationTimestamp
    @Column(name = "criado_em")
    private Date createdIn;

    @UpdateTimestamp
    @Column(name = "atualizado_em")
    private Date updatedIn;
}

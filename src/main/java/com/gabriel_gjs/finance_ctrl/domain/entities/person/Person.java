package com.gabriel_gjs.finance_ctrl.domain.entities.person;

import com.gabriel_gjs.finance_ctrl.domain.entities.user.User;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Table(name = "pessoa")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String name;

    @Column(name = "cpf", unique = true)
    private String cpf;

    @Column(name = "data_nascimento")
    private Date birthdayDate;

    @CreationTimestamp
    @Column(name = "criado_em")
    private Date createdIn;

    @UpdateTimestamp
    @Column(name = "atualizado_em")
    private Date updatedIn;

    @OneToOne
    @JoinColumn(name = "user_id", unique = true)
    private User user;
}

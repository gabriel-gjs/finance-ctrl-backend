package com.gabriel_gjs.finance_ctrl.domain.entities.user;

import com.gabriel_gjs.finance_ctrl.domain.entities.role.Role;
import com.gabriel_gjs.finance_ctrl.domain.entities.user.enums.UserStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "usuario")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long user_id;

    @Column(name = "email", unique=true)
    private String email;

    @Column(name = "senha")
    private String password;

    private UserStatus status;

    @CreationTimestamp
    @Column(name = "criado_em")
    private Date createdIn;

    @UpdateTimestamp
    @Column(name = "atualizado_em")
    private Date updatedIn;

    @Column(name = "atualizado_por")
    private User updatedBy;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "cargoDosUsuarios",
            joinColumns= @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles;
}

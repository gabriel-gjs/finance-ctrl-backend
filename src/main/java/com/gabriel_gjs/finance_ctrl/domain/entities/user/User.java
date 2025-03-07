package com.gabriel_gjs.finance_ctrl.domain.entities.user;

import com.gabriel_gjs.finance_ctrl.domain.entities.person.Person;
import com.gabriel_gjs.finance_ctrl.domain.entities.user.enums.UserRole;
import com.gabriel_gjs.finance_ctrl.domain.entities.user.enums.UserStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "usuario")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @Column(name = "email", unique=true)
    private String email;

    @Column(name = "senha")
    private String password;

    @Enumerated(EnumType.STRING)
    private UserStatus status;

    @Column(name = "cargo")
    @Enumerated(EnumType.STRING)
    private UserRole role;

    @CreationTimestamp
    @Column(name = "criado_em")
    private Date createdIn;

    @UpdateTimestamp
    @Column(name = "atualizado_em")
    private Date updatedIn;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Person person;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(this.role == UserRole.ADMIN) {
            return List.of(
                    new SimpleGrantedAuthority("ROLE_ADMIN"),
                    new SimpleGrantedAuthority("ROLE_USER")
            );
        }
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getUsername() {
        return this.email;
    }
}

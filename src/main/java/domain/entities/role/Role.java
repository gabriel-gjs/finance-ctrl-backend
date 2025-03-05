package domain.entities.role;

import jakarta.persistence.*;

@Entity
@Table(name = "cargo")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long role_id;

    @Column(name = "nome")
    private String name;


    public enum Values {
        ADMIN(1L),
        BASIC(2L);

        Long id;

        Values(Long id) {
            this.id = id;
        }

        Long getRoleId() {
            return this.id;
        }
    }
}

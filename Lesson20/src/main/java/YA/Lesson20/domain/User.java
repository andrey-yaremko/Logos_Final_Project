package YA.Lesson20.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.Objects;
@Data
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(unique = true)
    private String email;
    private String firstName;
    private String lastName;
    @Enumerated(EnumType.STRING)
    private UserRole userRole;
    private String password;
    private String passwordConfirm;

    public User() {
        super();
    }

    public User(User user) {
        this.id = user.id;
        this.email = user.email;
        this.firstName = user.firstName;
        this.lastName = user.lastName;
        this.password = user.password;
        this.userRole = user.userRole;
    }

    public User(String email, String firstName, String lastName, UserRole userRole, String password) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userRole = userRole;
        this.password = password;
    }
}

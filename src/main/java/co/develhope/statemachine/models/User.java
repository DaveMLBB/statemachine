package co.develhope.statemachine.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@Table(name = "users", uniqueConstraints = { @UniqueConstraint(columnNames = { "username" }),
        @UniqueConstraint(columnNames = { "email" }) })
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "username")
    @Size(max = 15)
    private String username;

    @Column(name = "isActive")
    private Boolean isActive = false;

    @Column(name = "activationCode")
    private String activationCode;


    @NotBlank
    @Size(max = 100)
    @Column(name = "password")
    private String password;

    @NotBlank
    @Size(max = 40)
    @Column(name = "email")
    @Email
    private String email;

    @Column(name = "website")
    private String website;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
    )
    private List<Role> roles;

}

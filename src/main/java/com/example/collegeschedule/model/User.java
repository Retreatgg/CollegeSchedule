package com.example.collegeschedule.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "users")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_id_gen")
    @SequenceGenerator(name = "users_id_gen", sequenceName = "users_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(max = 150)
    @NotNull
    @Column(name = "name", nullable = false, length = 150)
    private String name;

    @Size(max = 150)
    @NotNull
    @Column(name = "surname", nullable = false, length = 150)
    private String surname;

    @Size(max = 300)
    @NotNull
    @Column(name = "email", nullable = false, length = 300)
    private String email;

    @Size(max = 260)
    @NotNull
    @Column(name = "password", nullable = false, length = 260)
    private String password;

    @ColumnDefault("true")
    @Column(name = "enabled")
    private Boolean enabled;

    @ManyToMany
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new LinkedHashSet<>();

    @Size(max = 150)
    @NotNull
    @Column(name = "patronymic", nullable = false, length = 150)
    private String patronymic;
    private String token;

    @Column(name = "reset_password_number")
    private String resetPasswordToken;
}
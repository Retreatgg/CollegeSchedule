package com.example.collegeschedule.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "teachers")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "teachers_id_gen")
    @SequenceGenerator(name = "teachers_id_gen", sequenceName = "teachers_id_seq", allocationSize = 1)
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

    @Size(max = 150)
    @NotNull
    @Column(name = "patronymic", nullable = false, length = 150)
    private String patronymic;

    @ColumnDefault("true")
    @Column(name = "enabled")
    private Boolean enabled;

}
package com.example.collegeschedule.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "audiences_type")
public class AudiencesType {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "audiences_type_id_gen")
    @SequenceGenerator(name = "audiences_type_id_gen", sequenceName = "audiences_type_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(max = 100)
    @NotNull
    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @OneToMany(mappedBy = "type")
    private Set<Audience> audiences = new LinkedHashSet<>();

}
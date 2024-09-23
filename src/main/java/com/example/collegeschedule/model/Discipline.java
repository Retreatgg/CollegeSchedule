package com.example.collegeschedule.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "disciplines")
public class Discipline {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "disciplines_id_gen")
    @SequenceGenerator(name = "disciplines_id_gen", sequenceName = "disciplines_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(max = 250)
    @Column(name = "name", length = 250)
    private String name;

    @OneToMany(mappedBy = "discipline")
    private Set<Schedule> schedules = new LinkedHashSet<>();

}
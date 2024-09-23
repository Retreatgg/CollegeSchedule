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
@Table(name = "groups")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "groups_id_gen")
    @SequenceGenerator(name = "groups_id_gen", sequenceName = "groups_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(max = 250)
    @Column(name = "name", length = 250)
    private String name;

    @OneToMany(mappedBy = "group")
    private Set<Schedule> schedules = new LinkedHashSet<>();

}
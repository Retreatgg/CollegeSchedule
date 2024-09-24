package com.example.collegeschedule.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "audiences")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Audience {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "audiences_id_gen")
    @SequenceGenerator(name = "audiences_id_gen", sequenceName = "audiences_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(max = 10)
    @NotNull
    @Column(name = "number", nullable = false, length = 10)
    private String number;

    @NotNull
    @Column(name = "floor", nullable = false)
    private Integer floor;

    @Column(name = "capacity")
    private Integer capacity;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "type_id", nullable = false)
    private AudiencesType type;

    @OneToMany(mappedBy = "audience")
    private Set<Schedule> schedules = new LinkedHashSet<>();

}
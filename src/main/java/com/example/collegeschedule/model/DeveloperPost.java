package com.example.collegeschedule.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "developer_posts")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DeveloperPost {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "developer_posts_id_gen")
    @SequenceGenerator(name = "developer_posts_id_gen", sequenceName = "developer_posts_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "author_id", nullable = false)
    private User author;

    @Size(max = 150)
    @Column(name = "title", length = 150)
    private String title;

    @Column(name = "content", length = Integer.MAX_VALUE)
    private String content;

    @NotNull
    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @NotNull
    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;

    @ColumnDefault("false")
    @Column(name = "id_deleted")
    private Boolean idDeleted;

    @Size(max = 255)
    @Column(name = "image")
    private String image;

}
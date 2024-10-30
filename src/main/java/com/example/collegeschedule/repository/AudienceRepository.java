package com.example.collegeschedule.repository;

import com.example.collegeschedule.model.Audience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AudienceRepository extends JpaRepository<Audience, Long> {

    @Query("SELECT a FROM Audience a order by a.type.id, a.number ASC")
    List<Audience> findAudienceOrderByType();
}
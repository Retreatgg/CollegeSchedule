package com.example.collegeschedule.repository;

import com.example.collegeschedule.model.Discipline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DisciplineRepository extends JpaRepository<Discipline, Long> {
    @Query("SELECT d FROM Discipline d ORDER BY d.name ASC")
    List<Discipline> findALl();
}
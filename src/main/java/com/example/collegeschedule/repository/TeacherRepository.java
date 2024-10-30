package com.example.collegeschedule.repository;

import com.example.collegeschedule.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    @Query("SELECT t FROM Teacher t ORDER BY t.name ASC")
    List<Teacher> findAll();
}
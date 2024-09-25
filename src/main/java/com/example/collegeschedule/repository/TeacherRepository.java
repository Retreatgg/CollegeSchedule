package com.example.collegeschedule.repository;

import com.example.collegeschedule.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
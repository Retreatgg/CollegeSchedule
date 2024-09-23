package com.example.collegeschedule.repository;

import com.example.collegeschedule.model.AudiencesType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AudiencesTypeRepository extends JpaRepository<AudiencesType, Long> {
}
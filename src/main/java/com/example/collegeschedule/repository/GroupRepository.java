package com.example.collegeschedule.repository;

import com.example.collegeschedule.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {

    @Query("select g from Group g where g.course = :course order by g.name asc")
    List<Group> findByCourse(@Param("course") Integer course);

    @Query("select g from Group g order by g.name asc")
    List<Group> findAllBy();
}
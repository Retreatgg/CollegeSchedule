package com.example.collegeschedule.repository;

import com.example.collegeschedule.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select user from User user join user.roles role where role.role = 'TEACHER'")
    List<User> findTeachers();

}

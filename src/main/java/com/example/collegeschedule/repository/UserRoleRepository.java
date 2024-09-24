package com.example.collegeschedule.repository;

import com.example.collegeschedule.model.User;
import com.example.collegeschedule.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, User> {
}
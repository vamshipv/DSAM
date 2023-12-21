package com.example.DSAMAssignment.respository;

import com.example.DSAMAssignment.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, String> {
    Users findByUsername(String username);
}

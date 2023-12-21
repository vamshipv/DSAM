package com.example.DSAMAssignment.respository;

import com.example.DSAMAssignment.model.Crate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrateRepository extends JpaRepository<Crate, Long> {
}

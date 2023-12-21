package com.example.DSAMAssignment.respository;

import com.example.DSAMAssignment.model.Bottle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BottleRepository extends JpaRepository<Bottle, Long> {
}

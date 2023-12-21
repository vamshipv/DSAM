package com.example.DSAMAssignment.respository;

import com.example.DSAMAssignment.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Long> {
    List<Orders> findByUsersId(Long usersId);
}

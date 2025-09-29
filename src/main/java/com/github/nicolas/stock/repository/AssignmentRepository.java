package com.github.nicolas.stock.repository;

import com.github.nicolas.stock.entity.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssignmentRepository extends JpaRepository<Assignment, Integer> {


    boolean existsByEmployeeIdAndReturnedAtIsNull(int employeeId);
}

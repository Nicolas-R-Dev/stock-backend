package com.github.nicolas.stock.repository;

import com.github.nicolas.stock.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    Employee findByUnn(String unn);
}

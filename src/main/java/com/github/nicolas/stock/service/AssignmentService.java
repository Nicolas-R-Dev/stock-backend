package com.github.nicolas.stock.service;

import com.github.nicolas.stock.entity.Assignment;
import com.github.nicolas.stock.entity.Employee;
import com.github.nicolas.stock.repository.AssignmentRepository;
import org.springframework.stereotype.Service;

@Service
public class AssignmentService {
    private AssignmentRepository assignmentRepository;
    private EmployeeService employeeService;

    public AssignmentService(AssignmentRepository assignmentRepository, EmployeeService employeeService) {
        this.assignmentRepository = assignmentRepository;
        this.employeeService = employeeService;
    }

    public void create (Assignment assignment){
        Employee employee = this.employeeService.readOrCreate(assignment.getEmployee());
        assignment.setEmployee(employee);
        this.assignmentRepository.save(assignment);

    }
}

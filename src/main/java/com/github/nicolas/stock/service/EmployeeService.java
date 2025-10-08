package com.github.nicolas.stock.service;

import com.github.nicolas.stock.entity.Employee;
import com.github.nicolas.stock.exception.ConflictException;
import com.github.nicolas.stock.exception.NotFoundException;
import com.github.nicolas.stock.repository.AssignmentRepository;
import com.github.nicolas.stock.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private EmployeeRepository employeeRepository;
    private AssignmentRepository assignmentRepository;
    public EmployeeService(EmployeeRepository employeeRepository, AssignmentRepository assignmentRepository) {
        this.employeeRepository = employeeRepository;
        this.assignmentRepository = assignmentRepository;
    }


    public void create(Employee employee){
        Employee employeeByUnn =  this.employeeRepository.findByUnn(employee.getUnn());
        if (employeeByUnn == null) this.employeeRepository.save(employee);

    }

    public List<Employee> find(){
        return this.employeeRepository.findAll();
    }

    public Employee findById(int id){
        Optional<Employee> optionalEmployee =  this.employeeRepository.findById(id);
        return optionalEmployee.orElse(null);
    }

    public Employee readOrCreate(Employee employee) {

        Employee employeeByUnn =  this.employeeRepository.findByUnn(employee.getUnn());
        if (employeeByUnn == null) employeeByUnn =  this.employeeRepository.save(employee);

        return employeeByUnn;
    }

    @Transactional
    public void deleteEmployeeById(int id) {

        if (this.assignmentRepository.existsByEmployeeIdAndReturnedAtIsNull(id)){
            throw new ConflictException("Employee still has active assignments");
        }
        var employee = employeeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Employee not found"));

        employeeRepository.delete(employee);

    }
}

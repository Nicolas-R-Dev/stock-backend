package com.github.nicolas.stock.service;

import com.github.nicolas.stock.entity.Employee;
import com.github.nicolas.stock.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
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
}

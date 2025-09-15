package com.github.nicolas.stock.controller;

import com.github.nicolas.stock.entity.Employee;
import com.github.nicolas.stock.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "employee")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void create(@RequestBody Employee employee){
        this.employeeService.create(employee);
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<Employee> find(){
        return this.employeeService.find();
    }


    @GetMapping(path = "{id}",produces = APPLICATION_JSON_VALUE)
    public Employee findById(@PathVariable int id){
        return this.employeeService.findById(id);
    }
}

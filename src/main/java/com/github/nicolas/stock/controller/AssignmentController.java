package com.github.nicolas.stock.controller;

import com.github.nicolas.stock.entity.Assignment;
import com.github.nicolas.stock.entity.Employee;
import com.github.nicolas.stock.service.AssignmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "assignment", produces = MediaType.APPLICATION_JSON_VALUE)
public class AssignmentController {

    private AssignmentService assignmentService;

    public AssignmentController(AssignmentService assignmentService) {
        this.assignmentService = assignmentService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void create(@RequestBody Assignment assignment){
        this.assignmentService.create(assignment);
    }


    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<Assignment> find(){
        return this.assignmentService.find();
    }

}

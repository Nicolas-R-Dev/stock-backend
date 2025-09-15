package com.github.nicolas.stock.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDateTime;

import static jakarta.persistence.CascadeType.MERGE;
import static jakarta.persistence.CascadeType.PERSIST;

@Entity
@Table(name = "assignment")
public class Assignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "assigned_at", nullable = false, insertable = false, updatable = false)
    private LocalDateTime assigned_at;

    @JsonFormat(pattern = "yyyy-MM-dd['T'HH[:mm][:ss]]")
    private LocalDateTime returned_at;
    @Column(name = "device_id")
    private String device;

    @ManyToOne(cascade = {PERSIST, MERGE})
    private Employee employee;

    public Assignment() {
    }
    public Assignment(int id, String device, Employee employee, LocalDateTime returned_at) {
        this.id = id;
        this.device = device;
        this.employee = employee;
        this.returned_at = returned_at;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getAssigned_at() {
        return assigned_at;
    }

    public void setAssigned_at(LocalDateTime assigned_at) {
        this.assigned_at = assigned_at;
    }

    public LocalDateTime getReturned_at() {
        return returned_at;
    }

    public void setReturned_at(LocalDateTime returned_at) {
        this.returned_at = returned_at;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }


}

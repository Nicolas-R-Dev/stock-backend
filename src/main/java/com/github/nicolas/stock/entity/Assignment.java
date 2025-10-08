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
    private LocalDateTime assignedAt;

    @JsonFormat(pattern = "yyyy-MM-dd['T'HH[:mm][:ss]]")
    @Column(name = "returned_at")
    private LocalDateTime returnedAt;
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
        this.returnedAt = returned_at;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getAssignedAt() {
        return assignedAt;
    }

    public void setAssignedAt(LocalDateTime assignedAt) {
        this.assignedAt = assignedAt;
    }

    public LocalDateTime getReturnedAt() {
        return returnedAt;
    }

    public void setReturnedAt(LocalDateTime returnedAt) {
        this.returnedAt = returnedAt;
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

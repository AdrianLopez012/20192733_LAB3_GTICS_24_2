package com.example.lab3_20192733.entitiy;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;

@Entity
@Getter
@Setter
@Table(name="employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="employee_id",nullable = false)
    private Integer employee_id;

    @Column(name="first_name",length = 20)
    private String first_name;

    @Column(name="last_name",length = 25)
    private String last_name;

    @Column(name="email",length = 25)
    private String email;

    @Column(name="salary")
    private Integer salary;

    @Column(name="phone_number")
    private String phone_number;

    @Column(name="enabled")
    private Integer enabled;

    @ManyToOne
    @JoinColumn(name = "job_id")
    private Job job;


    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;


}


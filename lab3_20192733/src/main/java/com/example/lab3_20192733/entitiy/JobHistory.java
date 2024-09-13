package com.example.lab3_20192733.entitiy;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;

@Entity
@Getter
@Setter
@Table(name="job_history")
public class JobHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="job_history",nullable = false)
    private Integer job_history;

    @Column(name="start_date")
    private Integer start_date;

    @Column(name="end_date")
    private String end_date;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

}
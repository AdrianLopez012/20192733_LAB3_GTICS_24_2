package com.example.lab3_20192733.entitiy;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="departments")
public class Department {

    @Id
    @Column(name="department_id",nullable = false)
    private Integer department_id;

    @Column(name="department_name",nullable = false,length = 30)
    private String department_name;



    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;
}

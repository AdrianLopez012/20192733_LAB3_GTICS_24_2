package com.example.lab3_20192733.repository;

import com.example.lab3_20192733.entitiy.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer>{
}

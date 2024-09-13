package com.example.lab3_20192733.repository;

import com.example.lab3_20192733.entitiy.Employee;
import com.example.lab3_20192733.entitiy.JobHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobHistoryRepository extends JpaRepository<JobHistory,Integer>{
}
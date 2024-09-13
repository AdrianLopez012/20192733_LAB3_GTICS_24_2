package com.example.lab3_20192733.repository;

import com.example.lab3_20192733.entitiy.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<Job,String> {
}

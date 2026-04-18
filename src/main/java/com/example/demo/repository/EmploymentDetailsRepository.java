package com.example.demo.repository;

import com.example.demo.entity.EmploymentDetails;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface EmploymentDetailsRepository 
        extends JpaRepository<EmploymentDetails, String> {

    List<EmploymentDetails> findByUserId(String userId);
}
package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Table(name = "employment_details")
public class EmploymentDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employmentId;
    private String userId;
    private String employerName;
    private String designation;
    private Integer numberOfExpYears;
    private Double annualIncome;
    private boolean currentEmployer;
    
    // Getters & Setters
}

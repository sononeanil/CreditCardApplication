package com.hcl.card.entity;

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
    
    @Column(name = "userid", nullable = false, length = 100)
    private String userId;
    
    @Column(name = "employerName", nullable = false, length = 100)
    private String employerName;
    
    @Column(name = "designation", nullable = false, length = 100)
    private String designation;
    
    @Column(name = "numberOfExpYears", nullable = false, length = 2)
    private Integer numberOfExpYears;
    
    @Column(name = "annualIncome", nullable = false, length = 10)
    private Double annualIncome;
    
    private boolean currentEmployer;
    
    // Getters & Setters
}

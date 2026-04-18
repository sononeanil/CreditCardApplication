package com.hcl.card.repository;

import com.hcl.card.entity.EmploymentDetails;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface EmploymentDetailsRepository 
        extends JpaRepository<EmploymentDetails, String> {
}

package com.hcl.card.service;

import com.hcl.card.entity.EmploymentDetails;
import com.hcl.card.repository.EmploymentDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmploymentDetailsService {

    @Autowired
    private EmploymentDetailsRepository repository;

    public EmploymentDetails createEmployment(EmploymentDetails details) {
        return repository.save(details);
    }

    public EmploymentDetails getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employment not found"));
    }

    public List<EmploymentDetails> getByUserId(String userId) {
        return repository.findByUserId(userId);
    }

    public List<EmploymentDetails> getAll() {
        return repository.findAll();
    }

    public EmploymentDetails updateEmployment(String userId, EmploymentDetails updated) {
        EmploymentDetails existing = getByUserId(userId);

        existing.setEmployerName(updated.getEmployerName());
        existing.setJobTitle(updated.getJobTitle());
        existing.setEmploymentType(updated.getEmploymentType());
        existing.setAnnualIncome(updated.getAnnualIncome());
        existing.setYearsOfExperience(updated.getYearsOfExperience());

        return repository.save(existing);
    }

}

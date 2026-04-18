package com.example.demo.controller;

import com.example.demo.entity.EmploymentDetails;
import com.example.demo.repository.EmploymentDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employmentDetails")
public class EmploymentDetailsController {

    @Autowired
    private EmploymentDetailsService service;

    @PostMapping
    public ResponseEntity<EmploymentDetails> create(
            @RequestBody EmploymentDetails details) {
        return ResponseEntity.ok(service.createEmployment(details));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<EmploymentDetails>> getByUserId(
            @PathVariable String userId) {
        return ResponseEntity.ok(service.getByCustomerId(userId));
    }

    @PutMapping("/{userId}")
    public ResponseEntity<EmploymentDetails> updateEmployment(
            @PathVariable String userId,
            @RequestBody EmploymentDetails details) {
        return ResponseEntity.ok(service.updateEmployment(userId, details));
    }

}
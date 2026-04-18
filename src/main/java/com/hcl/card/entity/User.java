package com.hcl.card.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "userid", nullable = false, length = 100)
    private String userId;

    @Column(name = "firstname", nullable = false, length = 100)
    private String firstName;

    @Column(name = "lastname", length = 100)
    private String lastName;

    @Column(name = "email", nullable = false, unique = true, length = 150)
    private String email;

    @Column(name = "address", length = 200)
    private String address;

    @Column(name = "prevCreditCard", length = 150)
    private String prevCreditCard;

    @Column(name = "mobile", nullable = false, unique = true, length = 20)
    private String mobile;

    @Column(name = "dob")
    private LocalDate dob;

    @Column(name = "createddate", insertable = false, updatable = false)
    private LocalDateTime createddate;


}
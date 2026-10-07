package com.example.JobApplicationManagement.Entity;

import jakarta.persistence.*;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;

import java.time.Instant;
import java.util.List;


@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Valid
    private static String name;

    @Email
    private String email;

    private Instant createddate;


    @ManyToOne
    @JoinColumn(name = "companies_id")
    private Companies companies;



    @OneToMany( cascade = CascadeType.ALL)
    private List<JobApplications> jobApplications;


    public Companies getCompanies() {
        return companies;
    }

    public void setCompanies(Companies companies) {
        this.companies = companies;
    }


    public static String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Instant getCreateddate() {
        return createddate;
    }

    public void setCreateddate(Instant createddate) {
        this.createddate = createddate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

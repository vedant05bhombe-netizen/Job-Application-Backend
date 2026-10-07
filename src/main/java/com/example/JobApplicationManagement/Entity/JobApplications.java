package com.example.JobApplicationManagement.Entity;
import com.example.JobApplicationManagement.Enums.StatusEnums;
import jakarta.persistence.*;
import java.util.Date;

@Entity
public class JobApplications {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    private String position;

    private Date applicationdate;

    private int salary;


    private String joburl;

    private String note;

    @ManyToOne
    @JoinColumn(name = "users_id")
    private Users users;


    @ManyToOne
    @JoinColumn(name = "companies_id")
    private Companies companies;


    @Enumerated(EnumType.STRING)
    private StatusEnums status; // Change String to StatusEnums

    public Companies getCompanies() {
        return companies;
    }

    public void setCompanies(Companies companies) {
        this.companies = companies;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Date getApplicationdate() {
        return applicationdate;
    }

    public void setApplicationdate(Date applicationdate) {
        this.applicationdate = applicationdate;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getJoburl() {
        return joburl;
    }

    public void setJoburl(String joburl) {
        this.joburl = joburl;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

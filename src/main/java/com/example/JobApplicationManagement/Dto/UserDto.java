package com.example.JobApplicationManagement.Dto;


import com.example.JobApplicationManagement.Entity.Companies;
import com.example.JobApplicationManagement.Entity.JobApplications;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.Date;
import java.util.List;

@Data
@Getter
@Setter
public class UserDto {


    private String name;
    private String email;
    private Instant createddate;
    List<JobApplications> jobApplications;
    List<Companies> companies;

}

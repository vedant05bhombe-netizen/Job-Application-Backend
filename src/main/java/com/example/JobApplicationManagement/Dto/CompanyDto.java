package com.example.JobApplicationManagement.Dto;

import com.example.JobApplicationManagement.Entity.JobApplications;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
public class CompanyDto {

    private String name;
    private String location;
    private String website;
    private String industry;

    List<JobApplications> jobApplicationsList;
}

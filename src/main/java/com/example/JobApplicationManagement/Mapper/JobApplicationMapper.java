package com.example.JobApplicationManagement.Mapper;


import com.example.JobApplicationManagement.Dto.JobApplicationDto;
import com.example.JobApplicationManagement.Entity.JobApplications;
import com.example.JobApplicationManagement.Repository.JobApplicationRepo;

public class JobApplicationMapper {

    public static JobApplicationDto toJobApplicationDto(JobApplications jobApplications){
        JobApplicationDto jobApplicationDto = new JobApplicationDto();
        jobApplicationDto.setSalary(jobApplications.getSalary());
        jobApplicationDto.setPosition(jobApplications.getPosition());
        jobApplicationDto.setJoburl(jobApplications.getJoburl());
        jobApplicationDto.setApplicationdate(jobApplications.getApplicationdate());
        jobApplicationDto.setStatus(jobApplicationDto.getStatus());
        jobApplicationDto.setNote(jobApplications.getNote());

        return jobApplicationDto;


    }

    public static JobApplications toJobApplicationEntity(JobApplicationDto jobApplicationDto){
        JobApplications jobApplications = new JobApplications();
        jobApplications.setSalary(jobApplicationDto.getSalary());
        jobApplications.setPosition(jobApplicationDto.getPosition());
        jobApplications.setJoburl(jobApplicationDto.getJoburl());
        jobApplications.setNote(jobApplicationDto.getNote());
        jobApplications.setApplicationdate(jobApplicationDto.getApplicationdate());

        return jobApplications;

    }



}

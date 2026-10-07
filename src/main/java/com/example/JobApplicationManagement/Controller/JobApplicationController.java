package com.example.JobApplicationManagement.Controller;

import com.example.JobApplicationManagement.Dto.JobApplicationDto;
import com.example.JobApplicationManagement.Entity.JobApplications;
import com.example.JobApplicationManagement.Enums.StatusEnums;
import com.example.JobApplicationManagement.Service.JobApplicationService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JobApplicationController {

    JobApplicationService jobApplicationService;


    public JobApplicationController(JobApplicationService jobApplicationService) {
        this.jobApplicationService = jobApplicationService;
    }


    @PostMapping("post/jobapplications")
    public ResponseEntity<String> CreateJobApplications(@RequestBody JobApplicationDto jobApplicationDto){
        jobApplicationService.CreateJobApplication(jobApplicationDto);

        return ResponseEntity.status(HttpStatus.CREATED).body("The Application is Created");
    }

    @GetMapping("/get/applications")
    public ResponseEntity<Page<JobApplicationDto>> GetJobApplications(int page , int  size , String Sortedby , String direction){
        return ResponseEntity.ok(jobApplicationService.getallApplications(page , size , Sortedby , direction));

    }

    @GetMapping("/get/application/{id}")
    public ResponseEntity<JobApplications> GetApplicationsByid(@PathVariable Long id){
        return ResponseEntity.ok(jobApplicationService.getApplicationsbyId(id));
    }

    @DeleteMapping("/delete/jobapplication/{id}")
    public ResponseEntity<Void> DeleteApplicationByid(Long id){
        jobApplicationService.deleteApplicationsByid(id);
        return ResponseEntity.notFound().build();
    }
    @PutMapping("/update/application/{id}")
    public ResponseEntity<JobApplicationDto> UpdateApplicationbyId( @PathVariable Long id , @RequestBody JobApplicationDto updatedjobapplicationsto ){
        return ResponseEntity.ok(jobApplicationService.updateApplicationByid(id , updatedjobapplicationsto));
    }

    @GetMapping("/get/filter/bypostion")
    public ResponseEntity<List<JobApplicationDto>> FilterByPosition(String Position){
        return ResponseEntity.ok(jobApplicationService.FilterByPosition(Position));

    }
    @GetMapping("/get/Filter/bystatus")
    public ResponseEntity<List<JobApplicationDto>> FilterByStatus(StatusEnums status){
        return ResponseEntity.ok(jobApplicationService.FilterByStatus(status));

    }

    
}

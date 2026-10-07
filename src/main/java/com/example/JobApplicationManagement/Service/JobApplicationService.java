package com.example.JobApplicationManagement.Service;
import com.example.JobApplicationManagement.Dto.JobApplicationDto;
import com.example.JobApplicationManagement.Entity.JobApplications;
import com.example.JobApplicationManagement.Enums.StatusEnums;
import com.example.JobApplicationManagement.Mapper.JobApplicationMapper;
import com.example.JobApplicationManagement.Repository.JobApplicationRepo;
import com.example.JobApplicationManagement.Repository.UserRepo;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobApplicationService {
    JobApplicationRepo jobApplicationRepo;
    private final UserRepo userRepo;


    public JobApplicationService(JobApplicationRepo jobApplicationRepo,
                                 UserRepo userRepo) {
        this.jobApplicationRepo = jobApplicationRepo;
        this.userRepo = userRepo;
    }


    public String CreateJobApplication(JobApplicationDto jobApplicationDto){
        JobApplications jobApplications = JobApplicationMapper.toJobApplicationEntity(jobApplicationDto);
        jobApplicationRepo.save(jobApplications);
        return "Success";
    }

    public Page<JobApplicationDto> getallApplications(int page , int size, String Sortedby , String direction){

        Sort sort;
        if (direction.equalsIgnoreCase("desc")) {
            sort = Sort.by(Sortedby).descending();
        } else {
            sort = Sort.by(Sortedby).ascending();
        }

        Pageable pageable = PageRequest.of(page, size, sort);

        Page<JobApplications> jobApplications = jobApplicationRepo.findAll(pageable);

        return jobApplications.map(JobApplicationMapper::toJobApplicationDto);
    }



    public JobApplications getApplicationsbyId(Long id){
        Optional<JobApplications> jobApplications = jobApplicationRepo.findById(id);
        if(jobApplications.isEmpty()){
            throw new RuntimeException("obj does not exist");

        }
        return  jobApplications.get();
    }


    public void deleteApplicationsByid(Long id ){
        Optional<JobApplications> jobApplications = jobApplicationRepo.findById(id);
        if (jobApplications.isEmpty()){
            throw new RuntimeException("obj doesnt exist");

        }
        userRepo.deleteById(id);
    }

    @Transactional
    public JobApplicationDto updateApplicationByid(Long id , JobApplicationDto jobApplicationDto){
        Optional<JobApplications> jobApplications = jobApplicationRepo.findById(id);
        if (jobApplications.isEmpty()){
            throw new RuntimeException("Obj deosnt exist");

        }
        jobApplications.get().setSalary(jobApplicationDto.getSalary());
        jobApplications.get().setSalary(jobApplicationDto.getSalary());
        jobApplications.get().setJoburl(jobApplicationDto.getJoburl());
        jobApplications.get().setNote(jobApplicationDto.getNote());
        jobApplications.get().setApplicationdate(jobApplicationDto.getApplicationdate());

        return JobApplicationMapper.toJobApplicationDto(jobApplications.get());

    }



    public List<JobApplicationDto> FilterByStatus(StatusEnums statusEnums){
        return jobApplicationRepo
                .findByStatusContaining(statusEnums)
                .stream()
                .map(JobApplicationMapper::toJobApplicationDto)
                .toList();
    }

   public  List <JobApplicationDto> FilterByPosition(String Position){
        return jobApplicationRepo
                .findByPositionContaining(Position)
                .stream()
                .map(JobApplicationMapper::toJobApplicationDto)
                .toList();
   }





}
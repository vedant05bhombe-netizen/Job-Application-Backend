package com.example.JobApplicationManagement.Repository;

import com.example.JobApplicationManagement.Entity.JobApplications;
import com.example.JobApplicationManagement.Enums.StatusEnums;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobApplicationRepo extends JpaRepository<JobApplications,Long> {

    List<JobApplications> findByStatusContaining(StatusEnums Status);

    List<JobApplications> findByPositionContaining(String Position);

}

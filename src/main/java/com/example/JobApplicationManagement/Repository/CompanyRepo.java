package com.example.JobApplicationManagement.Repository;

import com.example.JobApplicationManagement.Entity.Companies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepo extends JpaRepository<Companies, Long> {

}

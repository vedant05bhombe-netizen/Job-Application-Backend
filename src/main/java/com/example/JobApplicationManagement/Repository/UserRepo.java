package com.example.JobApplicationManagement.Repository;

import com.example.JobApplicationManagement.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository <Users,Long> {
}

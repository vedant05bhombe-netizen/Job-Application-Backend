package com.example.JobApplicationManagement.Dto;
import com.example.JobApplicationManagement.Enums.StatusEnums;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data
@Getter
@Setter
public class JobApplicationDto {

    private String position;
    private Date applicationdate;
    private int salary;
    private String joburl;
    private String note;
    private StatusEnums status;
}

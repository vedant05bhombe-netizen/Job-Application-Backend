package com.example.JobApplicationManagement.Mapper;

import com.example.JobApplicationManagement.Dto.CompanyDto;
import com.example.JobApplicationManagement.Entity.Companies;

public class CompanyMapper {


    public static CompanyDto toCompantdto(Companies companies){
        CompanyDto companyDto = new CompanyDto();
        companyDto.setName(companies.getName());
        companyDto.setLocation(companies.getLocation());
        companyDto.setWebsite(companies.getWebsite());
        companyDto.setIndustry(companies.getIndustry());

        return companyDto;

    }

    public static Companies toCompanyEntity(CompanyDto companyDto){
        Companies companies = new Companies();
        companies.setName(companyDto.getName());
        companies.setWebsite(companyDto.getWebsite());
        companies.setLocation(companyDto.getLocation());
        companies.setIndustry(companyDto.getIndustry());


        return companies;
    }
}

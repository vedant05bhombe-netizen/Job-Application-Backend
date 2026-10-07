package com.example.JobApplicationManagement.Service;

import com.example.JobApplicationManagement.Dto.CompanyDto;

import com.example.JobApplicationManagement.Entity.Companies;
import com.example.JobApplicationManagement.Mapper.CompanyMapper;
import com.example.JobApplicationManagement.Repository.CompanyRepo;
import com.example.JobApplicationManagement.Repository.UserRepo;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

    CompanyRepo companyRepo;
    private final UserRepo userRepo;

    public CompanyService(CompanyRepo companyRepo,
                          UserRepo userRepo) {
        this.companyRepo = companyRepo;
        this.userRepo = userRepo;
    }


    public String createCompany(CompanyDto companyDto){
        Companies companies = CompanyMapper.toCompanyEntity(companyDto);
        companyRepo.save(companies);
        return "success";
    }

    public List<CompanyDto> getALLcompanies (){
         return companyRepo
                 .findAll()
                 .stream()
                 .map(CompanyMapper::toCompantdto)
                 .toList();
    }

    public Companies getById(Long id){
        Optional<Companies> companies = companyRepo.findById(id);
        if(companies.isEmpty()) {
            throw new RuntimeException("Object does not exist");

        }
            return companies.get();


    }

    public void deletebyId(Long id){
        userRepo.deleteById(id);

    }

    @Transactional
    public CompanyDto EditByid(Long id , CompanyDto updatedcompamydto){
        Optional<Companies> companies = companyRepo.findById(id);
       if(companies.isEmpty()){
           throw new RuntimeException("obj does not exist");

       }else{
           companies.get().setName(updatedcompamydto.getName());
           companies.get().setIndustry(updatedcompamydto.getIndustry());
         companies.get().setLocation(updatedcompamydto.getLocation());
         companies.get().setWebsite(updatedcompamydto.getWebsite());


         return CompanyMapper.toCompantdto(companies.get());

       }
    }






}

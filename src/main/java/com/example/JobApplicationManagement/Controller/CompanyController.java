package com.example.JobApplicationManagement.Controller;

import com.example.JobApplicationManagement.Dto.CompanyDto;
import com.example.JobApplicationManagement.Entity.Companies;
import com.example.JobApplicationManagement.Repository.UserRepo;
import com.example.JobApplicationManagement.Service.CompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CompanyController {

    CompanyService companyService;
    private final UserRepo userRepo;

    public CompanyController(CompanyService companyService,
                             UserRepo userRepo) {
        this.companyService = companyService;
        this.userRepo = userRepo;
    }

    @PostMapping("/post/company")
    public ResponseEntity<String> CreateUser(@RequestBody  CompanyDto companyDto){
       companyService.createCompany(companyDto);
       return ResponseEntity.status(HttpStatus.CREATED).body("The Company is Created");

    }
    @GetMapping("/get/companies")
    public ResponseEntity<List<CompanyDto>> getAllCompanies(){
        return ResponseEntity.ok(companyService.getALLcompanies());
    }

    @GetMapping("/get/company/{id}")
    public ResponseEntity<Companies> getuserById(@PathVariable Long id){
        return ResponseEntity.ok(companyService.getById(id));

    }
    @DeleteMapping("/company/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        companyService.deletebyId(id);

        return ResponseEntity.notFound().build();
    }

    @PutMapping("/company/edit/{id}")
    public ResponseEntity<CompanyDto> editCompany(@PathVariable Long id , @RequestBody CompanyDto updatedcompanydto){
        return ResponseEntity.ok(companyService.EditByid(id , updatedcompanydto));

    }

}

package com.starlab.microbiome.microbiomdata.controller;


import com.starlab.microbiome.microbiomdata.dto.CompanyDTO;
import com.starlab.microbiome.microbiomdata.model.Company;
import com.starlab.microbiome.microbiomdata.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ngs-kit/company/")
public class CompanyController {

    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> createCompany(@RequestBody CompanyDTO companyDTO) {
        Company company = new Company(companyDTO.getName());

        Company registeredCompany = companyService.register(company);

        return ResponseEntity.ok().body(registeredCompany);
    }
}

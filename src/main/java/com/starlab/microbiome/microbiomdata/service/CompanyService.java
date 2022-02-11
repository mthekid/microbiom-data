package com.starlab.microbiome.microbiomdata.service;

import com.starlab.microbiome.microbiomdata.model.Company;
import com.starlab.microbiome.microbiomdata.repo.CompanyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepo companyRepo;

    public Company register(Company company) {
        return companyRepo.save(company);
    }
}

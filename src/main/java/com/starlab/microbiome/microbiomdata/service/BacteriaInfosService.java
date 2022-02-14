package com.starlab.microbiome.microbiomdata.service;

import com.starlab.microbiome.microbiomdata.model.ngs.BacteriaInfo;
import com.starlab.microbiome.microbiomdata.repo.BacteriaInfosRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BacteriaInfosService {

    @Autowired
    private BacteriaInfosRepo bacteriaInfosRepo;

    public BacteriaInfo create(BacteriaInfo bacteriaInfo) {
        return bacteriaInfosRepo.save(bacteriaInfo);
    }
}

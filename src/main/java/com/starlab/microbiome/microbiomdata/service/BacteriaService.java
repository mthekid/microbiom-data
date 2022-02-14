package com.starlab.microbiome.microbiomdata.service;

import com.starlab.microbiome.microbiomdata.model.ngs.Bacteria;
import com.starlab.microbiome.microbiomdata.repo.BacteriaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BacteriaService {

    @Autowired
    private BacteriaRepo bacteriaRepo;

    public Bacteria register(Bacteria bacteria) {
        return bacteriaRepo.save(bacteria);
    }

    public Bacteria findByName(String name) {
        return bacteriaRepo.findByName(name);
    }
}

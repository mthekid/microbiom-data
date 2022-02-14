package com.starlab.microbiome.microbiomdata.controller.bacteria;

import com.starlab.microbiome.microbiomdata.dto.ngs.BacteriaDTO;
import com.starlab.microbiome.microbiomdata.model.ngs.Bacteria;
import com.starlab.microbiome.microbiomdata.service.BacteriaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bacteria")
public class BateriaController {

    private final BacteriaService bacteriaService;

    public BateriaController(BacteriaService bacteriaService) {
        this.bacteriaService = bacteriaService;
    }

    @PostMapping("register")
    public ResponseEntity<?> registerBacteria(@RequestBody BacteriaDTO bacteriaDTO) {
        Bacteria bacteria = Bacteria.builder()
                .name(bacteriaDTO.getName())
                .type(bacteriaDTO.getType())
                .isProbiotics(bacteriaDTO.getIsProbiotics())
                .build();

        Bacteria registeredBacteria = bacteriaService.register(bacteria);

        return ResponseEntity.ok().body(registeredBacteria);
    }
}

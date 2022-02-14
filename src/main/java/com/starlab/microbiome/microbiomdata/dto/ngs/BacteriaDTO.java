package com.starlab.microbiome.microbiomdata.dto.ngs;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BacteriaDTO {

    private String type;
    private String name;
    private String isProbiotics;
}

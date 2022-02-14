package com.starlab.microbiome.microbiomdata.dto.ngs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BacteriaInfosDTO {

    private String name;
    private String email;
    private String num;
    private String bacteriaName;
}

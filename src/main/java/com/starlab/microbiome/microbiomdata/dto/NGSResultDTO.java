package com.starlab.microbiome.microbiomdata.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NGSResultDTO {

    private String company;
    private String name;
    private String email;

}

package com.starlab.microbiome.microbiomdata.dto.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiBacteriaInfo {
    private String num;
    private String name;
    private String isProbiotics;
    private String type;
}

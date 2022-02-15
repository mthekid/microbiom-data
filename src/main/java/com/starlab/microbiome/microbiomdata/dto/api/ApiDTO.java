package com.starlab.microbiome.microbiomdata.dto.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiDTO {

    private String company;
    private String name;
    private List<List<ApiBacteriaInfo>> bacterias;
    private String inspectedDate;
}

package com.starlab.microbiome.microbiomdata.model.ngs;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
public class BacteriaInfo {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // NGS 결과지 1: N 연결
    @ManyToOne
    @JoinColumn(name = "ngs_result_id")
    @JsonIgnore
    private NgsResult ngsResult;

    @ManyToOne
    @JoinColumn(name = "bacteria_id")
    private Bacteria bacteria;

    private String bacteriaNum;

    @Builder
    public BacteriaInfo(NgsResult ngsResult, Bacteria bacteria, String bacteriaNum) {
        this.ngsResult = ngsResult;
        this.bacteria = bacteria;
        this.bacteriaNum = bacteriaNum;
    }
}

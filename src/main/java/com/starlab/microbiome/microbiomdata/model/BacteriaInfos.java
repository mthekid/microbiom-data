package com.starlab.microbiome.microbiomdata.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
public class BacteriaInfos {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // NGS 결과지 1: N 연결
    @ManyToOne
    @JoinColumn(name = "ngs_result_id")
    private NgsResult ngsResult;

    @ManyToOne
    @JoinColumn(name = "bacteria_id")
    private Bacteria bacteria;

    private Long bacteriaNum;

    @CreationTimestamp
    private LocalDate inspectedDate;

    @Builder
    public BacteriaInfos(NgsResult ngsResult, Bacteria bacteria) {
        this.ngsResult = ngsResult;
        this.bacteria = bacteria;
    }
}

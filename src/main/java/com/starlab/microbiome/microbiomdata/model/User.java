package com.starlab.microbiome.microbiomdata.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.starlab.microbiome.microbiomdata.model.ngs.NgsResult;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String email;
    private String medicalInfo;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<NgsResult> ngsResults = new ArrayList<>();

    @Builder
    public User(String name, String email, String medicalInfo) {
        this.name = name;
        this.email = email;
        this.medicalInfo = medicalInfo;
    }
}

package com.starlab.microbiome.microbiomdata.model.ngs;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.starlab.microbiome.microbiomdata.model.Company;
import com.starlab.microbiome.microbiomdata.model.User;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class NgsResult {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime inspectedDate = LocalDateTime.now();

    @OneToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

//    @OneToMany(mappedBy = "ngs_result")
//    @JsonIgnore
//    private List<BacteriaInfo> ngsResults = new ArrayList<>();

    @Builder
    private NgsResult(User user, Company company) {
        this.user = user;
        this.company = company;
    }
}

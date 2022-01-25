package com.starlab.microbiome.microbiomdata.model.microbiome.userdata;

import lombok.*;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "USER")
@Getter
@Setter
@ToString
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private long id; // 사용자 고유 식별 번호

    @Column(length=10, nullable = false)
    private String name;

    @Column(name = "UNIQUE_MEDICAL_NUMBER", nullable = false, unique = true)
    private String medicalUniqueInfo;

    protected User() {}

    public User(String name, String medicalUniqueInfo) {
        this.name = name;
        this.medicalUniqueInfo = medicalUniqueInfo;
    }
}

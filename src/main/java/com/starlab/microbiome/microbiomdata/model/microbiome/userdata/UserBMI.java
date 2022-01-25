package com.starlab.microbiome.microbiomdata.model.microbiome.userdata;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "BMI")
@ToString
@Getter
@Setter
@Builder
public class UserBMI {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "HEIGHT", nullable = false)
    private double height;

    @Column(name = "WEIGHT", nullable = false)
    private double weight;

    @Column(name = "AGE", nullable = false)
    private int age;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    protected UserBMI() {}
}

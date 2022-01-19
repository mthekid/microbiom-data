package com.starlab.microbiome.microbiomdata.model.microbiome;


import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "bacteria_information")
@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class Bacteria {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "scientific name", nullable = false)
    private String name;

    @Column(nullable = false)
    private String code;

    @Column(nullable = false)
    private Category category;
}

package com.starlab.microbiome.microbiomdata.model.microbiome;


import com.starlab.microbiome.microbiomdata.model.microbiome.converter.CategoryConverter;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "bacteria_information")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Bacteria {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "scientific name", nullable = false)
    private String name;

    @Column(nullable = false)
    private String code;

    @Convert(converter = CategoryConverter.class)
    private Category category;
}

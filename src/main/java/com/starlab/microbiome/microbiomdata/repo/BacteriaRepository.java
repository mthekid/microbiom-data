package com.starlab.microbiome.microbiomdata.repo;

import com.starlab.microbiome.microbiomdata.model.microbiome.Bacteria;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BacteriaRepository extends CrudRepository<Bacteria, Integer> {
}

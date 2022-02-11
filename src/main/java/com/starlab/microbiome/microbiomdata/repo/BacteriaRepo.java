package com.starlab.microbiome.microbiomdata.repo;

import com.starlab.microbiome.microbiomdata.model.Bacteria;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BacteriaRepo extends CrudRepository<Bacteria, Long> {
}

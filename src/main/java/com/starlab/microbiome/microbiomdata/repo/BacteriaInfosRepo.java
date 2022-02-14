package com.starlab.microbiome.microbiomdata.repo;

import com.starlab.microbiome.microbiomdata.model.ngs.BacteriaInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface BacteriaInfosRepo extends CrudRepository<BacteriaInfo, Long> {

}

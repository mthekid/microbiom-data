package com.starlab.microbiome.microbiomdata.repo;

import com.starlab.microbiome.microbiomdata.model.ngs.BacteriaInfo;
import com.starlab.microbiome.microbiomdata.model.ngs.NgsResult;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Repository
public interface BacteriaInfosRepo extends CrudRepository<BacteriaInfo, Long> {
    List<BacteriaInfo> findAllByNgsResult(NgsResult registeredNgsResult);
}

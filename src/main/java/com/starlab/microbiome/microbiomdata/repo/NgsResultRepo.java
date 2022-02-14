package com.starlab.microbiome.microbiomdata.repo;

import com.starlab.microbiome.microbiomdata.model.User;
import com.starlab.microbiome.microbiomdata.model.ngs.NgsResult;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NgsResultRepo extends CrudRepository<NgsResult, Long> {

    List<NgsResult> findAllByUser(User user);
}

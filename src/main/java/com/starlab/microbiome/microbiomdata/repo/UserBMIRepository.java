package com.starlab.microbiome.microbiomdata.repo;

import com.starlab.microbiome.microbiomdata.model.microbiome.userdata.UserBMI;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserBMIRepository extends CrudRepository<UserBMI, Long> {
}

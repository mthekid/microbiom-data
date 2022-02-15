package com.starlab.microbiome.microbiomdata.repo;

import com.starlab.microbiome.microbiomdata.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {

    boolean existsByMedicalInfo(String medicalInfo);
    User findByNameAndEmail(String name, String email);
    User findByMedicalInfo(String medicalInfo);

}

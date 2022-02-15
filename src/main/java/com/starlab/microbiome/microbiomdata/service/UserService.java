package com.starlab.microbiome.microbiomdata.service;

import com.starlab.microbiome.microbiomdata.model.User;
import com.starlab.microbiome.microbiomdata.model.ngs.NgsResult;
import com.starlab.microbiome.microbiomdata.repo.NgsResultRepo;
import com.starlab.microbiome.microbiomdata.repo.UserRepo;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private NgsResultRepo ngsResultRepo;

    public User lookUpUser(User user) {
        return userRepo.findByNameAndEmail(user.getName(), user.getEmail());
    }

    public User create(User user) {
        return userRepo.save(user);
    }

    public User getUserByMedicalInfo(String medicalInfo) {
        return userRepo.findByMedicalInfo(medicalInfo);
    }

    public List<NgsResult> getAllNgsResult(User registeredUser) {
        return ngsResultRepo.findAllByUser(registeredUser);
    }

    public NgsResult getRecentNgsResult(User registeredUser) {
        log.info(" UserService 계층 : 등록된 사용자의 이름 : " + registeredUser.getName() + " -> ");

        List<NgsResult> ngsResults = ngsResultRepo.findAllByUser(registeredUser);

        NgsResult registeredNgsResult = ngsResults.stream()
                .sorted(Comparator.comparing(NgsResult::getInspectedDate).reversed())
                .findFirst()
                .get();

        log.info("등록된 사용자의 최신 결과지 : " + registeredNgsResult.getId());

        return registeredNgsResult;
    }
}

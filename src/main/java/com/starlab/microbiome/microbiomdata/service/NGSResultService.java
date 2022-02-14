package com.starlab.microbiome.microbiomdata.service;

import com.starlab.microbiome.microbiomdata.model.Company;
import com.starlab.microbiome.microbiomdata.model.User;
import com.starlab.microbiome.microbiomdata.model.ngs.NgsResult;
import com.starlab.microbiome.microbiomdata.repo.CompanyRepo;
import com.starlab.microbiome.microbiomdata.repo.NgsResultRepo;
import com.starlab.microbiome.microbiomdata.repo.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
@Slf4j
public class NGSResultService {

    @Autowired
    private NgsResultRepo ngsResultRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private CompanyRepo companyRepo;

    public NgsResult findRecentResult(String name, String email) {

        User registeredUser = userRepo.findByNameAndEmail(name, email);

        log.info(" ngsResultService 계층 : 등록된 사용자의 이름 : " + registeredUser.getName() + " -> ");

        List<NgsResult> ngsResults = ngsResultRepo.findAllByUser(registeredUser);

        NgsResult registeredNgsResult = ngsResults.stream()
                .sorted(Comparator.comparing(NgsResult::getInspectedDate).reversed())
                .findFirst()
                .get();

        log.info("등록된 사용자의 최신 결과지 : " + registeredNgsResult.getId());

        return registeredNgsResult;
    }

    public NgsResult registerResult(User user, Company company) {
        User registeredUser = userRepo.findByNameAndEmail(user.getName(), user.getEmail());
        Company registerdCompnay = companyRepo.findByName(company.getName());

        NgsResult ngsResult = NgsResult.builder()
                .company(registerdCompnay)
                .user( registeredUser)
                .build();

        NgsResult registeredResult = ngsResultRepo.save(ngsResult);

        if(registeredResult == null) {
            throw new RuntimeException("등록된 사용자 혹은 회사가 없습니다.");
        }

        return registeredResult;
    }
}


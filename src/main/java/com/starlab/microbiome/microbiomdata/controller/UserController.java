package com.starlab.microbiome.microbiomdata.controller;

import com.starlab.microbiome.microbiomdata.dto.UserDTO;
import com.starlab.microbiome.microbiomdata.dto.api.ApiBacteriaInfo;
import com.starlab.microbiome.microbiomdata.dto.api.ApiDTO;
import com.starlab.microbiome.microbiomdata.model.User;
import com.starlab.microbiome.microbiomdata.model.ngs.BacteriaInfo;
import com.starlab.microbiome.microbiomdata.model.ngs.NgsResult;
import com.starlab.microbiome.microbiomdata.service.BacteriaInfosService;
import com.starlab.microbiome.microbiomdata.service.NGSResultService;
import com.starlab.microbiome.microbiomdata.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/ngs-kit/user")
@Slf4j
public class UserController {

    private final UserService userService;
    private final NGSResultService ngsResultService;
    private final BacteriaInfosService bacteriaInfosService;

    public UserController(UserService userService,
                          NGSResultService ngsResultService,
                          BacteriaInfosService bacteriaInfosService) {
        this.userService = userService;
        this.ngsResultService = ngsResultService;
        this.bacteriaInfosService = bacteriaInfosService;
    }

    @PostMapping("create")
    public ResponseEntity<?> createUser(@RequestBody UserDTO userDTO) {

        User user = User.builder()
                .email(userDTO.getEmail())
                .name(userDTO.getName())
                .medicalInfo(userDTO.getMedicalInfo())
                .build();

        User registeredUser = userService.create(user);

        UserDTO responseDTO = UserDTO.builder()
                .email(registeredUser.getEmail())
                .name(registeredUser.getName()).build();

        return ResponseEntity.ok(user);
    }

    @GetMapping("ngs-results")
    public ResponseEntity<?> getAllNgsResult(@RequestParam String medicalInfo) {
        User registeredUser = userService.getUserByMedicalInfo(medicalInfo);

        log.info("최근 사용자의 ngs 정보 조회 -> ");

        List<NgsResult> ngsResults = userService.getAllNgsResult(registeredUser);

        return ResponseEntity.ok().body(ngsResults);
    }

    @GetMapping("recent-ngs-result")
    public ResponseEntity<?> getRecentNgsResult(@RequestParam String medicalInfo) {
        User registeredUser = userService.getUserByMedicalInfo(medicalInfo);

        NgsResult recentNgsResult = userService.getRecentNgsResult(registeredUser);

        List<BacteriaInfo> bacteriaInfos = bacteriaInfosService.getRecentBacteriaInfos(recentNgsResult);

        List<ApiBacteriaInfo> apiBacteriaInfos = new ArrayList<>();

        for(BacteriaInfo bacteriaInfo : bacteriaInfos) {
            ApiBacteriaInfo record = ApiBacteriaInfo.builder()
                    .isProbiotics(bacteriaInfo.getBacteria().getIsProbiotics())
                    .name(bacteriaInfo.getBacteria().getName())
                    .num(bacteriaInfo.getBacteriaNum())
                    .type(bacteriaInfo.getBacteria().getType())
                    .build();

            apiBacteriaInfos.add(record);
        }

        List<List<ApiBacteriaInfo>> recentResult = new ArrayList<>();
        recentResult.add(apiBacteriaInfos);

        ApiDTO apiDTO = ApiDTO.builder()
                .name(registeredUser.getName())
                .company(recentNgsResult.getCompany().getName())
                .inspectedDate(recentNgsResult.getInspectedDate().toString())
                .bacterias(recentResult)
                .build();

        return ResponseEntity.ok().body(apiDTO);
    }
}

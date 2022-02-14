package com.starlab.microbiome.microbiomdata.controller.bacteria;

import com.starlab.microbiome.microbiomdata.dto.ngs.BacteriaInfosDTO;
import com.starlab.microbiome.microbiomdata.model.User;
import com.starlab.microbiome.microbiomdata.model.ngs.Bacteria;
import com.starlab.microbiome.microbiomdata.model.ngs.BacteriaInfo;
import com.starlab.microbiome.microbiomdata.model.ngs.NgsResult;
import com.starlab.microbiome.microbiomdata.service.BacteriaInfosService;
import com.starlab.microbiome.microbiomdata.service.BacteriaService;
import com.starlab.microbiome.microbiomdata.service.NGSResultService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 사용자의 마이크로바이옴 데이터 결과 박테리아 정보를 입력하는 컨트롤러이다.
 *
 */
@RestController
@RequestMapping("/ngs-kit/result")
@Slf4j
public class BacteriaInfosController {

    private final BacteriaInfosService bacteriaInfosService;
    private final NGSResultService ngsResultService;
    private final BacteriaService bacteriaService;

    public BacteriaInfosController(BacteriaInfosService bacteriaInfosService, NGSResultService ngsResultService, BacteriaService bacteriaService) {
        this.bacteriaInfosService = bacteriaInfosService;
        this.ngsResultService = ngsResultService;
        this.bacteriaService = bacteriaService;
    }

    @PostMapping("/sheet/record")
    public ResponseEntity<?> recordResultInfo(@RequestBody BacteriaInfosDTO bacteriaInfosDTO) {

        User inputUser = User.builder()
                .name(bacteriaInfosDTO.getName())
                .email(bacteriaInfosDTO.getEmail())
                .build();

        log.info("ngs/kit/result/sheet/record : 사용자 입력값 : " + inputUser.getName() + " , " + inputUser.getEmail() + " -> ");

        NgsResult recentNgsResult = ngsResultService.findRecentResult(inputUser.getName(), inputUser.getEmail());

        log.info("넘어온 박테리아 이름 확인 : " + bacteriaInfosDTO.getBacteriaName());

        Bacteria registeredBacteria = bacteriaService.findByName(bacteriaInfosDTO.getBacteriaName());

        log.info("박테리아 정보 확인 : " + registeredBacteria);

        log.info("결과지에 박테리아 정보 기입 : " + registeredBacteria);

        BacteriaInfo bacteriaInfo = BacteriaInfo.builder()
                .bacteria(registeredBacteria)
                .ngsResult(recentNgsResult)
                .bacteriaNum(bacteriaInfosDTO.getNum())
                .build();

        BacteriaInfo registeredBacteriaInfo = bacteriaInfosService.create(bacteriaInfo);

        return ResponseEntity.ok().body(registeredBacteriaInfo);
    }
}

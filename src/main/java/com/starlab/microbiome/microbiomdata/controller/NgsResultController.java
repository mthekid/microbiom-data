package com.starlab.microbiome.microbiomdata.controller;

import com.starlab.microbiome.microbiomdata.dto.ResponseDTO;
import com.starlab.microbiome.microbiomdata.dto.ngs.NGSResultDTO;
import com.starlab.microbiome.microbiomdata.model.Company;
import com.starlab.microbiome.microbiomdata.model.User;
import com.starlab.microbiome.microbiomdata.model.ngs.NgsResult;
import com.starlab.microbiome.microbiomdata.service.NGSResultService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ngs-kit/sheet")
public class NgsResultController {

    // NGS Result 처리할 Service 추가하기.

    private NGSResultService ngsResultService;

    public NgsResultController(NGSResultService ngsResultService) {
        this.ngsResultService = ngsResultService;
    }

    /*
        사용자 이메일, 이름, 회사 정보 입력받고 식별 ID 가져오고
        NGS Result로 저장하기.
         */
    @PostMapping("create")
    public ResponseEntity<?> registerResult(@RequestBody NGSResultDTO ngsResultDTO) {
        User inUser = User.builder()
                .name(ngsResultDTO.getName())
                .email(ngsResultDTO.getEmail())
                .build();

        Company inCompany = new Company(ngsResultDTO.getCompany());

        try {
            NgsResult registeredNgsResult = ngsResultService.registerResult(inUser, inCompany);
            return ResponseEntity.ok().body(registeredNgsResult);

        } catch (Exception e) {
            ResponseDTO responseDTO = ResponseDTO.builder()
                    .error(e.getMessage())
                    .build();

            return ResponseEntity.badRequest().body(responseDTO);
        }

    }
}

package com.starlab.microbiome.microbiomdata.controller;

import com.starlab.microbiome.microbiomdata.dto.UserDTO;
import com.starlab.microbiome.microbiomdata.model.User;
import com.starlab.microbiome.microbiomdata.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ngs-kit/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
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
}

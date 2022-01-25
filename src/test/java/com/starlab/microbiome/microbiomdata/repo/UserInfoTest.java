package com.starlab.microbiome.microbiomdata.repo;

import com.starlab.microbiome.microbiomdata.model.microbiome.userdata.User;
import com.starlab.microbiome.microbiomdata.model.microbiome.userdata.UserBMI;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
class UserInfoTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserBMIRepository userBMIRepository;

    @Test
    void userRepoSaveItems() {
        User user = new User(
                "문현준",
                "asd12410123"
        );

        UserBMI userBMI = UserBMI.builder()
                .age(26)
                .height(178.6)
                .weight(88.7)
                .user(user)
                .build();

        User savedUser = userRepository.save(user);
        UserBMI savedUserBMI = userBMIRepository.save(userBMI);

        assertThat(savedUser.getId()).isNotNull();
    }

}
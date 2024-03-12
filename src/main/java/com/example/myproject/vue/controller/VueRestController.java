package com.example.myproject.vue.controller;

import com.example.myproject.common.annotation.LoginId;
import com.example.myproject.vue.dto.CreateExperienceDto;
import com.example.myproject.vue.dto.Experience;
import com.example.myproject.vue.service.VueService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vue-test")
@RequiredArgsConstructor
@Slf4j
public class VueRestController {

    private final VueService vueServiceImpl;

    @PostMapping("/experiences")
    public ResponseEntity CreateExperience(@RequestBody CreateExperienceDto createExperienceDto
        , @LoginId String username, @AuthenticationPrincipal String user) {
        createExperienceDto.setUsername(username);
        vueServiceImpl.createExperience(createExperienceDto);
        return ResponseEntity.ok("ok");
    }

    @GetMapping("/experiences")
    public ResponseEntity findAllExperiences() {
        List<Experience> list = vueServiceImpl.findAllExperiences();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }
}

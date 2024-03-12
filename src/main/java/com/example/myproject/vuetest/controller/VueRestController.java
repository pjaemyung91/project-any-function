package com.example.myproject.vuetest.controller;

import com.example.myproject.common.annotation.LoginId;
import com.example.myproject.vuetest.dto.CreateExperienceDto;
import com.example.myproject.vuetest.service.VueService;
import java.lang.reflect.Type;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
    public ResponseEntity findAllExperience(@RequestBody CreateExperienceDto createExperienceDto
        , @LoginId String loginId, @AuthenticationPrincipal String user) {
//        vueServiceImpl.createExperience(createExperienceDto);
        return ResponseEntity.ok("ok");
    }
}

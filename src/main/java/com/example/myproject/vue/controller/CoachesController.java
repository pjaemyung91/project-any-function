package com.example.myproject.vue.controller;

import com.example.myproject.vue.dto.Coach;
import com.example.myproject.vue.dto.CoachRegistrationDto;
import com.example.myproject.vue.service.CoachesService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/coaches")
@Slf4j
public class CoachesController {

    private final CoachesService coachesServiceImpl;

    @PostMapping("/coach")
    public ResponseEntity registerCoach(@RequestBody CoachRegistrationDto coachRegistrationDto) {
        log.info(coachRegistrationDto.toString());
        coachesServiceImpl.registerCoach(coachRegistrationDto);
        return ResponseEntity.status(HttpStatus.OK).body("ok");
    }

    @GetMapping("/list")
    public ResponseEntity findAllCoaches() {
        List<Coach> coaches = coachesServiceImpl.findAllCoaches();
        return ResponseEntity.status(HttpStatus.OK).body(coaches);
    }
}

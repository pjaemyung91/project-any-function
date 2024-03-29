package com.example.myproject.vue.service;

import com.example.myproject.vue.dto.Coach;
import com.example.myproject.vue.dto.CoachRegistrationDto;
import java.util.List;

public interface CoachesService {

    void registerCoach(CoachRegistrationDto coachRegistrationDto);

    List<Coach> findAllCoaches();
}

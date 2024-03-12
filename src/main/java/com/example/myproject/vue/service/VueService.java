package com.example.myproject.vue.service;

import com.example.myproject.vue.dto.CreateExperienceDto;
import com.example.myproject.vue.dto.Experience;
import java.util.List;

public interface VueService {

    void createExperience(CreateExperienceDto createExperienceDto);

    List<Experience> findAllExperiences();
}

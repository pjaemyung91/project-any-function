package com.example.myproject.vue.dao;

import com.example.myproject.vue.dto.Coach;
import com.example.myproject.vue.dto.CoachRegistrationDto;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CoachDao {

    void registerCoach(CoachRegistrationDto coachRegistrationDto);

    List<Coach> findAllCoaches();
}

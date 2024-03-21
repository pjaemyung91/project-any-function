package com.example.myproject.vue.service;

import com.example.myproject.vue.dao.CoachDao;
import com.example.myproject.vue.dto.Coach;
import com.example.myproject.vue.dto.CoachRegistrationDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CoachesServiceImpl implements CoachesService{

    private final CoachDao coachDao;

    @Override
    public void registerCoach(CoachRegistrationDto coachRegistrationDto) {
        coachRegistrationDto.convertAreas();
        coachDao.registerCoach(coachRegistrationDto);
    }

    @Override
    public List<Coach> findAllCoaches() {
        return coachDao.findAllCoaches();
    }
}

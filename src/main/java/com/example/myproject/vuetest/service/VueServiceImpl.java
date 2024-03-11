package com.example.myproject.vuetest.service;

import com.example.myproject.vuetest.dao.VueDao;
import com.example.myproject.vuetest.dto.CreateExperienceDto;
import com.example.myproject.vuetest.exception.CreateExperienceFailException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VueServiceImpl implements VueService{

    private final VueDao vueDao;

    @Override
    public void createExperience(CreateExperienceDto createExperienceDto) {
        try{
            vueDao.createExperience(createExperienceDto);
        }catch(Exception e) {
            throw new CreateExperienceFailException("Fail to Create Experience");
        }
    }
}

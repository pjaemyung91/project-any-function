package com.example.myproject.vue.service;

import com.example.myproject.vue.dao.VueDao;
import com.example.myproject.vue.dto.CreateExperienceDto;
import com.example.myproject.vue.dto.Experience;
import com.example.myproject.vue.exception.CreateExperienceFailException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
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

    @Override
    public List<Experience> findAllExperiences() {
        return vueDao.findAllExperiences();
    }
}

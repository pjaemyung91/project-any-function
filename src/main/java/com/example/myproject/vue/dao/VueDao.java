package com.example.myproject.vue.dao;

import com.example.myproject.vue.dto.CreateExperienceDto;
import com.example.myproject.vue.dto.Experience;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface VueDao {

    void createExperience(CreateExperienceDto createExperienceDto);

    List<Experience> findAllExperiences();
}

package com.example.myproject.vuetest.dao;

import com.example.myproject.vuetest.dto.CreateExperienceDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface VueDao {

    void createExperience(CreateExperienceDto createExperienceDto);
}

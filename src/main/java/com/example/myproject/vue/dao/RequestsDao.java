package com.example.myproject.vue.dao;

import com.example.myproject.vue.dto.Request;
import com.example.myproject.vue.dto.RequestAdditionDto;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RequestsDao {

    void addRequest(RequestAdditionDto requestAdditionDto);

    List<Request> findRequestsByCoachId(String coachId);
}

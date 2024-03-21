package com.example.myproject.vue.service;

import com.example.myproject.vue.dto.Request;
import com.example.myproject.vue.dto.RequestAdditionDto;
import java.util.List;

public interface RequestsService {

    RequestAdditionDto addRequest(RequestAdditionDto requestAdditionDto);

    List<Request> findRequestsByCoachId(String coachId);
}

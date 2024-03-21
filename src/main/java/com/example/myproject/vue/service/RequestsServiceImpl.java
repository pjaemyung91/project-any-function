package com.example.myproject.vue.service;

import com.example.myproject.vue.dao.RequestsDao;
import com.example.myproject.vue.dto.Request;
import com.example.myproject.vue.dto.RequestAdditionDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RequestsServiceImpl implements RequestsService{

    private final RequestsDao requestsDao;

    @Override
    public RequestAdditionDto addRequest(RequestAdditionDto requestAdditionDto) {
        requestsDao.addRequest(requestAdditionDto);
        return requestAdditionDto;
    }

    @Override
    public List<Request> findRequestsByCoachId(String coachId) {
        return requestsDao.findRequestsByCoachId(coachId);
    }
}

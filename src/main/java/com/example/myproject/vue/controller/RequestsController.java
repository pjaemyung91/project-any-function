package com.example.myproject.vue.controller;

import com.example.myproject.vue.dto.Request;
import com.example.myproject.vue.dto.RequestAdditionDto;
import com.example.myproject.vue.service.RequestsService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/requests")
public class RequestsController {

    private final RequestsService RequestsServiceImpl;

    @PostMapping("/request")
    public ResponseEntity addRequest(@RequestBody RequestAdditionDto requestAdditionDto ) {
        RequestAdditionDto responseData = RequestsServiceImpl.addRequest(requestAdditionDto);
        return ResponseEntity.status(HttpStatus.OK).body(responseData);
    }

    @GetMapping("/{coachId}")
    public ResponseEntity findRequestsByCoachId(@PathVariable("coachId") String coachId) {
        List<Request> requests = RequestsServiceImpl.findRequestsByCoachId(coachId);
        return ResponseEntity.status(HttpStatus.OK).body(requests);
    }
}

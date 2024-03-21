package com.example.myproject.vue.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestAdditionDto {

    private int id;
    private String coachId;
    private String userEmail;
    private String message;
}

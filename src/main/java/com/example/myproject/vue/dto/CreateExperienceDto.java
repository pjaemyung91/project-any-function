package com.example.myproject.vue.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class CreateExperienceDto {

    private String username;
    private String name;
    private String rating;
}

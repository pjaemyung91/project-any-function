package com.example.myproject.vue.dto;

import java.awt.geom.Area;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CoachRegistrationDto {

    private int coachId;
    private String firstName;
    private String lastName;
    private String description;
    private int hourlyRate;
    private List<String> areas;
}

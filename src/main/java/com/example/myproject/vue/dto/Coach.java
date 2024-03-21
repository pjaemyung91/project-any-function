package com.example.myproject.vue.dto;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Coach {

    private String coachId;
    private String firstName;
    private String lastName;
    private String description;
    private int hourlyRate;
    private String stringAreas;
}

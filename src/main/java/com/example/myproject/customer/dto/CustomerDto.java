package com.example.myproject.customer.dto;

import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {

    private int customerId;
    private String name;
    private String email;
    private String mobileNumber;
    private String pwd;
    private String role;
    private String createDt;
    private Set<Authority> authorities;
}

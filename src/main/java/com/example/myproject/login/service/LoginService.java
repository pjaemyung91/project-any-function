package com.example.myproject.login.service;

import com.example.myproject.customer.dto.CustomerDto;

public interface LoginService {

    CustomerDto registerUser(CustomerDto customerDto);
}

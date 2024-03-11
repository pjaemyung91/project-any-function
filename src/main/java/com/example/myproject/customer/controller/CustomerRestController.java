package com.example.myproject.customer.controller;

import com.example.myproject.customer.dto.CustomerDto;
import com.example.myproject.customer.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class CustomerRestController {

    private final CustomerService customerServiceImpl;

    @GetMapping("/register")
    public String register() {
        return "This is a register page";
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerCustomer(@RequestBody CustomerDto customerDto) {
        CustomerDto savedUser = null;
        ResponseEntity response = null;
        try {
            savedUser = customerServiceImpl.registerCustomer(customerDto);
            if (savedUser != null) {
                response = ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body("Given user details are successfully registered");
            }
        } catch (Exception ex) {
            response = ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("An exception occurred due to " + ex.getMessage());
        }
        return response;
    }

    @RequestMapping("/user")
    public CustomerDto getUserDetailsAfterLogin(Authentication authentication) {
        log.info("username = {}", authentication.getName());
        return null;
    }
}

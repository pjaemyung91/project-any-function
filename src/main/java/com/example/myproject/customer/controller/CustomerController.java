package com.example.myproject.customer.controller;

import com.example.myproject.customer.dto.CustomerDto;
import com.example.myproject.customer.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerServiceImpl;

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

//    @GetMapping("/user")
//    public Customer getUserDetailsAfterLogin(Authentication authentication) {
//        List<Customer> customers = customerRepository.findByEmail(authentication.getName());
//        if (customers.size() > 0) {
//            return customers.get(0);
//        } else {
//            return null;
//        }
//
//    }
}

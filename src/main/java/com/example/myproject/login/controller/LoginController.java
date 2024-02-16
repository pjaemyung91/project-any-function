package com.example.myproject.login.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LoginController {

//    private final LoginService loginServiceImpl;

//    @PostMapping("/register")
//    public ResponseEntity<String> registerUser(@RequestBody UserDto userDto) {
//        UserDto savedUser = null;
//        ResponseEntity response = null;
//        try {
//            savedUser = loginServiceImpl.registerUser(userDto);
//            if (savedUser.getId() > 0) {
//                response = ResponseEntity
//                    .status(HttpStatus.CREATED)
//                    .body("Given user details are successfully registered");
//            }
//        } catch (Exception ex) {
//            response = ResponseEntity
//                .status(HttpStatus.INTERNAL_SERVER_ERROR)
//                .body("An exception occured due to " + ex.getMessage());
//        }
//        return response;
//    }

}

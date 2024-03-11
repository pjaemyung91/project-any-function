package com.example.myproject.login.controller;

import com.example.myproject.common.config.security.SecurityDao;
import com.example.myproject.common.config.security.SecurityService;
import com.example.myproject.customer.dto.CustomerDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LoginController {

    private final SecurityDao securityDao;
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

//    @RequestMapping("/user")
//    public CustomerDto getUserDetailsAfterLogin(Authentication authentication) {
//        List<CustomerDto> customers = securityDao.findUserByEmail(authentication.getName());
//        if (customers.size() > 0) {
//            return customers.get(0);
//        } else {
//            return null;
//        }
//    }
}

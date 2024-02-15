package com.example.myproject.main.controller;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class MainController {

    private final ServletContext servletContext;

    @GetMapping("/")
    public void defaultRequest(HttpServletResponse response) throws IOException {
        String rootPath = servletContext.getContextPath();
        response.sendRedirect(rootPath + "/main");
    }

    @GetMapping("/main")
    public String main() {
        return "This is a main page";
    }
}

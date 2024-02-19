package com.example.myproject.common.filter.security;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.filter.OncePerRequestFilter;

//@Slf4j
public class RequestValidationBeforeFilter extends OncePerRequestFilter {

    private final Logger LOG = Logger.getLogger(RequestValidationBeforeFilter.class.getName());

//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//        throws IOException, ServletException {
//        log.info("RequestValidationBeforeFilter called");
//        chain.doFilter(request, response);
//    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
        FilterChain filterChain) throws ServletException, IOException {
        LOG.info("RequestValidationBeforeFilter called");
        filterChain.doFilter(request, response);
    }
}

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
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

public class AuthoritiesLoggingAfterFilter extends OncePerRequestFilter {

    private final Logger LOG = Logger.getLogger(AuthoritiesLoggingAfterFilter.class.getName());

//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//        throws IOException, ServletException {
//
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        if(authentication != null) {
//            LOG.info("USER" + authentication.getName()
//                + "is successfully authenticated and has the authorities"
//                + authentication.getAuthorities().toString());
//        }
//
//        chain.doFilter(request, response);
//    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
        FilterChain filterChain) throws ServletException, IOException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication != null) {
            LOG.info("USER" + authentication.getName()
                + " is successfully authenticated and has the authorities"
                + authentication.getAuthorities().toString());
        }

        filterChain.doFilter(request, response);
    }
}

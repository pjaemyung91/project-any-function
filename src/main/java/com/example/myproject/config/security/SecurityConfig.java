package com.example.myproject.config.security;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer.FrameOptionsConfig;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

//@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests((requests) -> requests
//            .requestMatchers(PathRequest.toH2Console()).permitAll()
            .requestMatchers("/", "/main").authenticated())
//            .csrf(csrf -> csrf.ignoringRequestMatchers(PathRequest.toH2Console()))
//            .headers(headers -> headers.frameOptions(FrameOptionsConfig::sameOrigin))
            .formLogin(Customizer.withDefaults())
            .httpBasic(Customizer.withDefaults());

        /**
         *  Configuration to deny all the requests
         */
//        http.authorizeHttpRequests(requests -> requests.anyRequest().denyAll())
//                .formLogin(Customizer.withDefaults())
//                .httpBasic(Customizer.withDefaults());

        /**
         * permit all without authentication
         */
//        http.authorizeHttpRequests((requests) -> requests.anyRequest().permitAll());

        return http.build();
    }

//    @Bean
//    @ConditionalOnProperty(name = "spring.h2.console.enabled",havingValue = "true")
//    public WebSecurityCustomizer configureH2ConsoleEnable() {
//        return web -> web.ignoring()
//            .requestMatchers(PathRequest.toH2Console());
//    }

    @Bean
    public InMemoryUserDetailsManager userDetailService() {
        UserDetails admin = User.withDefaultPasswordEncoder()
            .username("admin")
            .password("12345")
            .authorities("admin")
            .build();

        UserDetails user = User.withDefaultPasswordEncoder()
            .username("user")
            .password("12345")
            .authorities("read")
            .build();

        return new InMemoryUserDetailsManager(admin, user);
    }
}

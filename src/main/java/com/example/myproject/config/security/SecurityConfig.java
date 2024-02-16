package com.example.myproject.config.security;

import static org.springframework.security.config.Customizer.withDefaults;

import jakarta.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Collections;
import javax.sql.DataSource;
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
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

//@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.cors(withDefaults())
            .csrf((csrf) -> csrf.disable())
            .authorizeHttpRequests((requests) -> requests
//            .requestMatchers(PathRequest.toH2Console()).permitAll()
                .requestMatchers("/register").permitAll()
                .requestMatchers("/", "/main", "/users").authenticated())
//            .csrf(csrf -> csrf.ignoringRequestMatchers(PathRequest.toH2Console()))
//            .headers(headers -> headers.frameOptions(FrameOptionsConfig::sameOrigin))
            .formLogin(withDefaults())
            .httpBasic(withDefaults());

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

//    @Bean
//    public InMemoryUserDetailsManager userDetailService() {
//        UserDetails admin = User.withDefaultPasswordEncoder()
//            .username("admin")
//            .password("12345")
//            .authorities("admin")
//            .build();
//
//        UserDetails user = User.withDefaultPasswordEncoder()
//            .username("user")
//            .password("12345")
//            .authorities("read")
//            .build();
//
//        return new InMemoryUserDetailsManager(admin, user);
//    }

//    @Bean
//    public UserDetailsService userDetailsService(DataSource dataSource) {
//        return new JdbcUserDetailsManager(dataSource);
//    }

    /**
     * 비밀번호 인코딩 관련 빈 설정은 매우 중요
     * 스프링 시큐리티에게 비밀번호 암호화 관련 정보를 주는 것으로
     * 인증 시 어떠한 방법으로 비밀번호를 확인할 지 알려주는 것임
     */
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return NoOpPasswordEncoder.getInstance();
//    }

    @Bean
    public BCryptPasswordEncoder bcryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
        configuration.setAllowedMethods(Collections.singletonList("*"));
//        configuration.setAllowedMethods(Arrays.asList("GET","POST"));
        configuration.setAllowCredentials(true);
        configuration.setAllowedHeaders(Collections.singletonList("*"));
        configuration.setMaxAge(3600L);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}

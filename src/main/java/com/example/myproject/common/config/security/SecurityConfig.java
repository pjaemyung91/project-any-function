package com.example.myproject.common.config.security;

import static org.springframework.security.config.Customizer.withDefaults;

import com.example.myproject.common.filter.security.AuthoritiesLoggingAfterFilter;
import com.example.myproject.common.filter.security.AuthoritiesLoggingAtFilter;
import com.example.myproject.common.filter.security.CsrfCookieFilter;
import com.example.myproject.common.filter.security.JWTTokenGeneratorFilter;
import com.example.myproject.common.filter.security.JWTTokenValidatorFilter;
import com.example.myproject.common.filter.security.RequestValidationBeforeFilter;
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
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer.FrameOptionsConfig;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRequestAttributeHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
public class SecurityConfig {

    /**
     * spring boot 3.x.x와 spring security 6.x에서는 and() 메소드가 deprecated -> lamda사용
     */
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        CsrfTokenRequestAttributeHandler requestAttributeHandler = new CsrfTokenRequestAttributeHandler();
        requestAttributeHandler.setCsrfRequestAttributeName("_csrf");

        http
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//            .securityContext((context) -> context.requireExplicitSave(false))
//            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.ALWAYS))
//            .cors((cors) -> cors.configurationSource(myCorsConfigurationSource()))
            .cors(corsCustomizer -> corsCustomizer.configurationSource(new CorsConfigurationSource() {
                @Override
                public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
                    CorsConfiguration config = new CorsConfiguration();
//                    config.setAllowedOrigins(Collections.singletonList("http://localhost:8080"));
                    config.setAllowedOriginPatterns(Arrays.asList("*"));
                    config.setAllowedMethods(Collections.singletonList("*"));
                    config.setAllowCredentials(true);
                    config.setAllowedHeaders(Collections.singletonList("*"));
                    config.setExposedHeaders(Arrays.asList("Authorization"));   // jwt 관련 설정
                    config.setMaxAge(3600L);
                    return config;
                }
            }))
            .csrf(csrf -> csrf.disable())
//            .csrf((csrf) -> csrf.csrfTokenRequestHandler(requestAttributeHandler).ignoringRequestMatchers("/register")
//                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()))
//            .addFilterAfter(new CsrfCookieFilter(), BasicAuthenticationFilter.class)
//            .addFilterBefore(new RequestValidationBeforeFilter(), BasicAuthenticationFilter.class)
//            .addFilterAt(new AuthoritiesLoggingAtFilter(), BasicAuthenticationFilter.class)
//            .addFilterAfter(new AuthoritiesLoggingAfterFilter(), BasicAuthenticationFilter.class)
            .addFilterAfter(new JWTTokenGeneratorFilter(), BasicAuthenticationFilter.class)
            .addFilterBefore(new JWTTokenValidatorFilter(), BasicAuthenticationFilter.class)
            .authorizeHttpRequests((requests) -> requests
//            .requestMatchers(PathRequest.toH2Console()).permitAll()
//                .requestMatchers("/", "/main", "/users").hasAnyAuthority("VIEWACCOUNT", "VIEWCARDS")) // 권한으로 접근제어
                .requestMatchers("/", "/main").hasAnyRole("ADMIN", "USER")    // 역할로 접근 제어, 스프링 시큐리티가 자동으로 접두사 ROLE_을 붙임
//                .requestMatchers("/", "/main", "/users").authenticated()
                .requestMatchers("/user", "/vue-test/**").authenticated()
                .requestMatchers("/register", "/coaches/**", "/requests/**").permitAll())
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
    CorsConfigurationSource myCorsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
//        configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
        configuration.setAllowedOriginPatterns(Arrays.asList("*"));
        configuration.setAllowedMethods(Collections.singletonList("*"));
//        configuration.setAllowedMethods(Arrays.asList("GET","POST"));
        configuration.setAllowCredentials(true);
        configuration.setAllowedHeaders(Collections.singletonList("*"));
        configuration.setExposedHeaders(Arrays.asList("Authorization"));
        configuration.setMaxAge(3600L);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}

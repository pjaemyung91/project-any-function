package com.example.myproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
//@EnableWebSecurity(debug = true) // legacy spring project에서 sprint security를 사용하려면 명시해줘야 됨. 이 코드는 debug를 위해 추가함.
//@ComponentScan(nameGenerator = CustomBeanNameGenerator.class)
public class MyProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyProjectApplication.class, args);
	}

}

package com.example.myproject;

import com.example.myproject.config.CustomBeanNameGenerator;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@EnableWebSecurity // legacy spring project에서 sprint security를 사용하려면 명시해줘야 됨
//@ComponentScan(nameGenerator = CustomBeanNameGenerator.class)
public class MyProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyProjectApplication.class, args);
	}

}

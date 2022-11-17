package com.example.s3_docker_practice.docker_practice;

import com.example.s3_docker_practice.docker_practice.filter.JwtFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DockerPracticeApplication {

	public static void main(String[] args) {

		SpringApplication.run(DockerPracticeApplication.class, args);
	}

	@Bean
	public FilterRegistrationBean filterBean(){
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean<>();
		filterRegistrationBean.setFilter(new JwtFilter());
		filterRegistrationBean.addUrlPatterns("/userdata/v1/fetchusers");
		return filterRegistrationBean;
	}
}

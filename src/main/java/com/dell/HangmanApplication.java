package com.dell;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.WebApplicationInitializer;

import com.dell.dto.HangmanSessionBean;
import com.dell.filters.CookieSetter;
import com.dell.filters.GuessLetterFilter;


//implement WebApplicationInitializer to configure web.xml programmatically
@SpringBootApplication(scanBasePackages = {"com.dell.hangman",
        "com.dell.controllers",
        "com.dell.sessionlisteners",
        "com.dell.services",
        "com.dell.dao"})
@EntityScan("com.dell.entities")
public class HangmanApplication implements WebApplicationInitializer {

	public static void main(String[] args) {
		SpringApplication.run(HangmanApplication.class, args);
	}

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {

	}
	
	@Bean
	public HangmanSessionBean hangmanSessionBean() {
		return new HangmanSessionBean();
	}

	@Bean
	public FilterRegistrationBean guessLetterFilterRegistration() {
	    FilterRegistrationBean registration = new FilterRegistrationBean();
	    registration.setFilter(guessLetterFilter());
	    registration.addUrlPatterns("/api/v1/hangman/guessword");
	    registration.setName("guessLetterFilter");
	    return registration;
	}
	
	@Bean
	public FilterRegistrationBean cookieSetterRegistration() {
	    FilterRegistrationBean registration = new FilterRegistrationBean();
	    registration.setFilter(cookieSetterFilter());
	    registration.addUrlPatterns("/api/v1/hangman/*");
	    registration.setName("cookieSetterFilter");
	    return registration;
	}
	
	@Bean
	public CookieSetter cookieSetterFilter() {
		return new CookieSetter();
	}
	
	@Bean
	public GuessLetterFilter guessLetterFilter() {
		return new GuessLetterFilter();
	}
	
	
}






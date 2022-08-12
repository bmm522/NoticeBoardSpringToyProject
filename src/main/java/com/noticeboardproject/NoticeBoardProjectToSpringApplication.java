package com.noticeboardproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class NoticeBoardProjectToSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(NoticeBoardProjectToSpringApplication.class, args);
	}

}

package com.download.files.fileLoader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.sql.SQLException;


@SpringBootApplication
@EnableWebMvc
public class FileLoaderApplication {

	public ApplicationContext applicationContext;

	public static void main(String[] args) throws SQLException {
		ApplicationContext context = SpringApplication.run(FileLoaderApplication.class);
	}
}

package com.api.blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfug {

	@Bean
	public OpenAPI blogOpenAPI() {
		return new OpenAPI().info(new Info().title("Blog API - API Corporativa").version("1.0.0").description("API didatica para posts e comentarios"));
	}
	
	 
}

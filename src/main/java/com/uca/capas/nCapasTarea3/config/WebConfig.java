package com.uca.capas.nCapasTarea3.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

@Configuration
public class WebConfig {
	@Bean
	public ViewResolver viewResolver() {
		ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
		viewResolver.setTemplateEngine(templateEngine());
		viewResolver.setCharacterEncoding("UTF-8");
		return viewResolver;
	}
	@Bean
	public ClassLoaderTemplateResolver templateResolver() {
		ClassLoaderTemplateResolver cLTemplateResolver = new ClassLoaderTemplateResolver();
		cLTemplateResolver.setPrefix("templates/");
		cLTemplateResolver.setSuffix(".html");
		cLTemplateResolver.setTemplateMode("HTML");
		cLTemplateResolver.setCharacterEncoding("UTF-8");
		return cLTemplateResolver;
	}
	@Bean
	public SpringTemplateEngine templateEngine() {
		SpringTemplateEngine sTemplateEngine = new SpringTemplateEngine();
		sTemplateEngine.setTemplateResolver(templateResolver());
		return sTemplateEngine;
	}
	public void addResourcesHandler(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("resources/**").addResourceLocations("/resources/");
	}
}

package com.task.betslip.swagger;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author sunil
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	private static final Set<String> DEFAULT_PRODUCES_CONSUMES = new HashSet<String>(
			Arrays.asList("application/json"));

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(metaData())
				.produces(DEFAULT_PRODUCES_CONSUMES)
				.consumes(DEFAULT_PRODUCES_CONSUMES).select()
				.apis(RequestHandlerSelectors.any()).paths(PathSelectors.any())
				.build();
	}

	private ApiInfo metaData() {
		return new ApiInfoBuilder().title("Betslip Application").build();
	}
}

package io.javabrains.springboot.swagger2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@SpringBootApplication
@EnableSwagger2
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public Docket swaggerConfiguration(){

		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/api/*"))
				.apis(RequestHandlerSelectors.basePackage("io.javabrains"))
				.build()
				.apiInfo(apiDetails());

	}
	private ApiInfo apiDetails(){
		return new ApiInfo(
				"Address book API",
				"Sample API for JavaBrains tutorial",
				"1.0",
				"Free to use",
				new springfox.documentation.service.Contact("Andrii Rudyk", "http://google.com", "mymail@gmail.com"),
				"API License",
				"http://google.com",
				Collections.emptyList());


	}

}

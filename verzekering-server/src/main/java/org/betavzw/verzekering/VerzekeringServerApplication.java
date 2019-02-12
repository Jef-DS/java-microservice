package org.betavzw.verzekering;

import org.betavzw.verzekering.client.VerzekeringnemerReader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
@EnableSwagger2
public class VerzekeringServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(VerzekeringServerApplication.class, args);
	}
	@Bean
	public Docket swaggerApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
					.apis(RequestHandlerSelectors.basePackage("org.betavzw.verzekering"))
					.paths(PathSelectors.any())
				.build()
				.apiInfo(new ApiInfoBuilder().version("1.0").title("Verzekering API").description("Documentation Verzekering API v1.0").build());
	}
	@Bean
	public VerzekeringEngine Engine() {
		return new VerzekeringEngine();
	}
	@Bean
	public VerzekeringnemerReader Reader() {
		return new VerzekeringnemerReader();
	}
}


package org.betavzw.klant;

import java.time.LocalDate;
import java.time.Month;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class KlantServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(KlantServerApplication.class, args);
	}
	@Bean
	public Docket swaggerApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
					.apis(RequestHandlerSelectors.basePackage("org.betavzw.klant"))
					.paths(PathSelectors.any())
				.build()
				.apiInfo(new ApiInfoBuilder().version("1.0").title("Klant API").description("Documentation Klant API v1.0").build());
	}
	@Bean
	KlantRepository repository() {
		KlantRepository repository = new KlantRepository();
		repository.add(new Klant(1, "Karen", "Damen", LocalDate.of(1974, Month.OCTOBER, 28), true) );
		repository.add(new Klant(2, "Kristel", "Verfbeke", LocalDate.of(1975, Month.DECEMBER, 10), true) );
		repository.add(new Klant(3, "Kathlee", "Aerts", LocalDate.of(1978, Month.JUNE, 18), true) );
		repository.add(new Klant(4, "Gert", "Verhulst", LocalDate.of(1968, Month.JANUARY, 24), true) );
		return repository;
	}

}


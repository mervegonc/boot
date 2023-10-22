package spring.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;/*
											import springfox.documentation.builders.PathSelectors;
											import springfox.documentation.builders.RequestHandlerSelectors;
											import springfox.documentation.spi.DocumentationType;
											import springfox.documentation.spring.web.plugins.Docket;
											import springfox.documentation.swagger2.annotations.EnableSwagger2;*/

/*import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;*/

@Configuration
//@EnableSwagger2
@SpringBootApplication
public class BootApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootApplication.class, args);
	}

	@Bean
	public OpenAPI usersMicroserviceOpenAPI() {
		return new OpenAPI().info(new Info().title("spring.boot").description("Your API Description").version("1.0"));
	}

	/*
	 * @Bean public Docket productApi() { return new
	 * Docket(DocumentationType.SWAGGER_2).select()
	 * .apis(RequestHandlerSelectors.basePackage("com.tutorialspoint.swaggerdemo")).
	 * build(); }
	 */

}

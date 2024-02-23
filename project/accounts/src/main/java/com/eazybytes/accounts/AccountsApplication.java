package com.eazybytes.accounts;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableFeignClients
@EnableJpaAuditing(auditorAwareRef = "AuditAwareImpl")
@OpenAPIDefinition(
		info = @Info(
				title = "Accounts Microservices REST API Documentation",
				description = "Bank Accounts microservice REST API Documentation",
				version = "v1",
				contact = @Contact(
						name = "Ricardo Rodrigues",
						email = "ricardo.dorito@gmail.com"
				),
				license = @License (
						name = "Apache 2.0"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Bank Accounts microservice REST API"
		)
)
public class AccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountsApplication.class, args);
	}

}

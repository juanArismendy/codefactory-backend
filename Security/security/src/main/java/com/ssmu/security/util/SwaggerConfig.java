package com.ssmu.security.util;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

@Configuration
@OpenAPIDefinition(info = @Info(title = "Security API", version = "${api.version}", contact = @Contact(name = "UdeA", email = "sssmu@udea.edu.co", url = "https://www.udea.edu.co"), license = @License(name = "Apache 2.0", url = "https://www.apache.org/licenses/LICENSE-2.0"), termsOfService = "${tos.uri}", description = "${api.description}"), servers = @Server(url = "/", description = "Production"))

// @Configuration
public class SwaggerConfig {

    // @Bean
    // public GroupedOpenApi publicApi() {
    // return GroupedOpenApi.builder()
    // .group("springshop-public")
    // .pathsToMatch("/apiv1/**")
    // .build();
    // }

    // @Bean
    // public GroupedOpenApi adminApi() {
    // return GroupedOpenApi.builder()
    // .group("springshop-admin")
    // .pathsToMatch("/users/**")
    // .build();
    // }
}

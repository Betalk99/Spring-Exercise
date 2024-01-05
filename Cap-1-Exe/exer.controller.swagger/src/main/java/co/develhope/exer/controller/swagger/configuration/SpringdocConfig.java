package co.develhope.exer.controller.swagger.configuration;


import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springdoc.core.customizers.OpenApiCustomiser;
import org.springdoc.core.customizers.PropertyCustomizer;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.tags.Tag;

@Configuration
@EnableWebMvc
public class SpringdocConfig implements WebMvcConfigurer {

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("springshop-public")
                .addOpenApiCustomizer(openApi -> {
                    openApi.getInfo().setTitle("Controller con documentazione in Swagger");
                    openApi.getInfo().setDescription("Esercizio Get e Post del nome");
                    openApi.getInfo().setVersion("1.0");

//                    Tag echo = new Tag().name("echo").description("descrizione echo");
//                    Tag tag2 = new Tag().name("Tag2").description("descrizione tag 2");
//
//                    openApi.getTags().add(echo);
//                    openApi.getTags().add(tag2);
                })
                .build();
    }


//    @Bean
//    public OpenAPI customOpenAPI() {
//        return new OpenAPI()
//                .info(new Info()
//                        .title("Controller con documentazione in Swagger")
//                        .version("1.0")
//                        .description("Esercizio Get e Post del nome"));
//    }
}
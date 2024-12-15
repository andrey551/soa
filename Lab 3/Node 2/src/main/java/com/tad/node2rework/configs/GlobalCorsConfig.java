package com.tad.node2rework.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class GlobalCorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Allow CORS for all endpoints
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:*")  // Allow specific frontend domain
                .allowedMethods("GET, POST, PUT, DELETE, OPTIONS, HEAD")  // Allowed HTTP methods
                .allowedHeaders("origin, content-type, accept, authorization")  // Allow all headers
                .allowCredentials(true)
                .maxAge(3600);  // Cache pre-flight request for 1 hour
    }
}

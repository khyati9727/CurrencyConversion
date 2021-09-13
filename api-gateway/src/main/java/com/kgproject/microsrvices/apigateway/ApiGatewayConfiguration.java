package com.kgproject.microsrvices.apigateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ApiGatewayConfiguration {

    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder){
        return builder.routes()
                .route(p->p.path("/get").uri("http://httpbin.org:80"))
                .route(p->p.path("/currency-exchange/**").uri("lb://CURRENCY-EXCHANGE"))
                .route(p->p.path("/currency-conversion/**").uri("lb://CURRENCY-CONVERSION"))
                .route(p->p.path("/currency-conversion-feign/**").uri("lb://CURRENCY-CONVERSION"))
                .build();
    }
}

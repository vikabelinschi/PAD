package com.example.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

	@Bean
	RouteLocator gateway (RouteLocatorBuilder rlb){
		return rlb
				.routes()
				.route("login", routeSpec -> routeSpec
						.path("/login")
						.uri("http://localhost:9000")
				)
				.route("register", routeSpec -> routeSpec
						.path("/register")
						.filters(gatewayFilterSpec -> gatewayFilterSpec.setPath("/register"))
						.uri("http://localhost:9000/")
				)
				.route("addVideo", routeSpec -> routeSpec
						.path("/addVideo")
						.filters(gatewayFilterSpec ->
								gatewayFilterSpec.setPath("/add_Video"))
						.uri("http://localhost:8080/")
				)
				.route("comment", routeSpec -> routeSpec
						.path("/addComment")
						.filters(gatewayFilterSpec ->
								gatewayFilterSpec.setPath("/add_comment"))
						.uri("http://localhost:8082/"))
				.route("like", routeSpec -> routeSpec
						.path("/like")
						.filters(gatewayFilterSpec ->
								gatewayFilterSpec.setPath("/add_like"))
						.uri("http://localhost:8081/"))
				.build();
	}
}
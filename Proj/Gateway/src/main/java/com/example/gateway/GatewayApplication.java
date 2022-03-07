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
						.filters(gatewayFilterSpec -> gatewayFilterSpec.setPath("/authenticate"))
						.uri("http://localhost:9000")
				)
				.route("register", routeSpec -> routeSpec
						.path("/register")
						.filters(gatewayFilterSpec -> gatewayFilterSpec.setPath("/process_register"))
						.uri("http://localhost:9000/")
				)
				.route("videos", r -> r
						.path("/videos")
						.filters(f -> f.stripPrefix(1))
						.uri("http://localhost:8080")
				)
				.route("video", routeSpec -> routeSpec
						.path("/{video_id}")
						.filters(f -> f.setPath("/{video_id}"))
						.uri("http://localhost:8080")
				)
				.route("video_comments", routeSpec -> routeSpec
						.path("/{video_id}/comments")
						.filters(gatewayFilterSpec -> gatewayFilterSpec.setPath("/{video_id}"))
						.uri("http://localhost:8082/")
				)
				.route("video_likes", routeSpec -> routeSpec
						.path("/{video_id}/likes")
						.filters(gatewayFilterSpec -> gatewayFilterSpec.setPath("/{video_id}"))
						.uri("http://localhost:8081/")
				)
				.route("addVideo", routeSpec -> routeSpec
						.path("/addVideo")
						.filters(gatewayFilterSpec ->
								gatewayFilterSpec.setPath("/add_Video"))
						.uri("http://localhost:8080/")
				)
				.route("add_comment", routeSpec -> routeSpec
						.path("/add_comment")
						.uri("http://localhost:8082/add_comment"))
				.route("like", routeSpec -> routeSpec
						.path("/like")
						.filters(gatewayFilterSpec ->
								gatewayFilterSpec.setPath("/add_like"))
						.uri("http://localhost:8081/"))
				.build();
	}
}
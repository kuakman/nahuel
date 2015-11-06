package com.nahuel.web;

import org.jacpfx.vertx.spring.SpringVerticle;
import org.springframework.stereotype.Component;

import com.nahuel.web.config.DefaultConfiguration;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpServer;

@Component
@SpringVerticle(springConfig = DefaultConfiguration.class)
public class Server extends AbstractVerticle {
	
	private HttpServer http;
	
	@Override
	public void start() throws Exception {
		this.initialize().routes().listen(8080);
		super.start();
	}
	
	protected Server initialize() {
		this.http = vertx.createHttpServer();
		return this;
	}
	
	protected HttpServer routes() {
		//router.route().handler(ctx -> { this.html(ctx); });
		return this.http;
	}
    
}

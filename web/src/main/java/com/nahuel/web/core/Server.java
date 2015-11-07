package com.nahuel.web.core;

import io.vertx.core.http.HttpServer;
import io.vertx.ext.web.Router;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.nahuel.web.controller.impl.HomeController;
import com.nahuel.web.core.provider.ServerProvider;

public class Server implements ServerProvider {
	
	private Router router;
	private HttpServer http;
	
	@Inject HomeController homeController;
	
	public Server(HttpServer http, Router router) {
		this.http = http;
		this.router = router;
	}
	
	@Override
	public Router getRouter() {
		return this.router;
	}

	@Override
	public HttpServer getHttp() {
		return this.http;
	}

	@Override
	public ServerProvider routes(Injector injector) {
		injector.injectMembers(homeController);
		homeController.map();
		return this;
	}

}

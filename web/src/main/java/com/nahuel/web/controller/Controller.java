package com.nahuel.web.controller;

import io.vertx.ext.web.Route;
import io.vertx.ext.web.RoutingContext;

public interface Controller {

	void map();
	Route route(String path, String method);
	void html(RoutingContext ctx, String path);
	void json(RoutingContext ctx);
	
}

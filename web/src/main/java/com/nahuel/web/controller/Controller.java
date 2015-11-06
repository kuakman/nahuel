package com.nahuel.web.controller;

import io.vertx.ext.web.RoutingContext;

public interface Controller {

	void html(RoutingContext ctx);
	void json(RoutingContext ctx);
	
}

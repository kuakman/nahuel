package com.nahuel.web.controller.impl;

import io.vertx.ext.web.Route;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.templ.JadeTemplateEngine;

import com.google.inject.Inject;
import com.nahuel.web.controller.Controller;
import com.nahuel.web.core.provider.ProviderFactory;

public class BaseController implements Controller  {
	
	@Inject ProviderFactory factory;
	@Inject JadeTemplateEngine engine;
	
	@Override
	public void map() {}
	
	@Override
	public Route route(String path, String method) {
		return this.factory.get().getRouter().route(path);
	}
	
	@Override
	public void html(RoutingContext ctx, String path) {
		this.engine.render(ctx, path, res -> {
			if(res.succeeded()) {
				ctx.response().end(res.result());
			} else {
				ctx.fail(res.cause());
			}
		});
	}
	
	@Override
	public void json(RoutingContext ctx) {
		
	}

}

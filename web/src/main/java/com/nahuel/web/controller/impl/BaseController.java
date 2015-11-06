package com.nahuel.web.controller.impl;

import com.nahuel.web.controller.Controller;

import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.templ.JadeTemplateEngine;

public class BaseController implements Controller  {

	protected Router router;
	
	private JadeTemplateEngine engine;
	
	protected String basePath = "/index";
	
	public BaseController() {
		this.engine = JadeTemplateEngine.create();
	}
	
	public void html(RoutingContext ctx) {
		this.engine.render(ctx, "templates/index.jade", res -> {
			if(res.succeeded()) {
				ctx.response().end(res.result());
			} else {
				ctx.fail(res.cause());
			}
		});
	}
	
	public void json(RoutingContext ctx) {
		
	}

}

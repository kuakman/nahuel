package com.nahuel.web.controller.impl;

import io.vertx.ext.web.RoutingContext;

public class HomeController extends BaseController {
	
	public void map() {
		this.route("/home", "home").handler(ctx -> { this.home(ctx); });
		this.route("/contact", "contact").handler(ctx -> { this.contact(ctx); });
	}
	
	public void home(RoutingContext ctx) {
		this.html(ctx, "home/home.jade");
	}
	
	public void contact(RoutingContext ctx) {
		this.html(ctx, "home/contact.jade");
	}
	
}

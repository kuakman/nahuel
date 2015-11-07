package com.nahuel.web.core;

import io.vertx.core.AbstractVerticle;
import io.vertx.ext.web.Router;

import com.nahuel.web.core.provider.ProviderFactory;
import com.nahuel.web.core.provider.ServerProvider;

public class ServerFactory implements ProviderFactory {
	
	private Server server;
	
	@Override
	public ServerProvider create(AbstractVerticle vertx) {
		if(this.server != null) return this.server;
		this.server = new Server(vertx.getVertx().createHttpServer(), Router.router(vertx.getVertx()));
		return this.server;
	}

	@Override
	public ServerProvider get() {
		return this.server;
	}

}

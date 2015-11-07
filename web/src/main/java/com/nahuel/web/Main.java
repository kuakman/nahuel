package com.nahuel.web;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Verticle;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.nahuel.web.config.DefaultConfiguration;
import com.nahuel.web.core.provider.ProviderFactory;
import com.nahuel.web.core.provider.ServerProvider;

public class Main extends AbstractVerticle implements Verticle {
	
	@Inject private ProviderFactory serverFactory;
	
	private Injector injector;
	
	private ServerProvider server;
	
	public ServerProvider initialize() {
		this.injector = Guice.createInjector(new DefaultConfiguration());
		this.injector.injectMembers(this);
		this.server = serverFactory.create(this);
		this.injector.injectMembers(this.server);
		return this.server.routes(injector);
	}
	
	@Override
	public void start() throws Exception {
		this.initialize().getHttp().requestHandler(this.server.getRouter()::accept).listen(8080);
		super.start();
	}
    
}

package com.nahuel.web.core.provider;

import io.vertx.core.http.HttpServer;
import io.vertx.ext.web.Router;

import com.google.inject.Injector;

public interface ServerProvider {
	 Router getRouter();
	 HttpServer getHttp();
	 ServerProvider routes(Injector injector);
}

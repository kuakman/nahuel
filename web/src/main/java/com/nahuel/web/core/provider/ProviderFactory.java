package com.nahuel.web.core.provider;

import io.vertx.core.AbstractVerticle;

public interface ProviderFactory {
	ServerProvider create(AbstractVerticle server);
	ServerProvider get();
}

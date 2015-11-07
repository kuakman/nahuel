package com.nahuel.web.config;

import io.vertx.ext.web.templ.JadeTemplateEngine;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.nahuel.web.controller.impl.HomeController;
import com.nahuel.web.core.ServerFactory;
import com.nahuel.web.core.provider.ProviderFactory;

import de.neuland.jade4j.template.FileTemplateLoader;

public class DefaultConfiguration extends AbstractModule {
	
	@Provides
	public JadeTemplateEngine engine() {
		JadeTemplateEngine engine = JadeTemplateEngine.create();
		engine.getJadeConfiguration().setTemplateLoader(new FileTemplateLoader("classpath:templates/", "UTF-8"));
		return engine;
	}

	@Override
	protected void configure() {
		bind(ProviderFactory.class).to(ServerFactory.class).in(Singleton.class);
		bind(HomeController.class);
	}
	
}

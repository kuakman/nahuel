package com.nahuel.web.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
@ComponentScan(basePackages = {"com.nahuel.controller.impl.*"})
public class DefaultConfiguration {

}

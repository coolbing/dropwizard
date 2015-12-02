package com.dropwizard;

import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;

public class HelloWorldService extends Service<HelloWorldConfiguration> {

	public static void main(String[] args) throws Exception {
		new HelloWorldService().run(args);
	}

	@Override
	public void initialize(Bootstrap<HelloWorldConfiguration> bootstrap) {
		bootstrap.setName("helloWorld");
	}

	@Override
	public void run(HelloWorldConfiguration helloWorldConfiguration,
			Environment environment) throws Exception {
		final String template = helloWorldConfiguration.getTemplate();
		final String defaultName = helloWorldConfiguration.getDefaultName();
		environment.addResource(new HelloWorldResource(template, defaultName));
		environment.addHealthCheck(new TemplateHealthCheck(template));
	}
}

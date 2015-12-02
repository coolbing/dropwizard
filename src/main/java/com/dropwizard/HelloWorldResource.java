package com.dropwizard;

import java.util.concurrent.atomic.AtomicLong;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.google.common.base.Optional;

@Path("/hello")
@Produces(MediaType.APPLICATION_JSON)
public class HelloWorldResource {

	private final String template;

	private final String defaultName;

	private final AtomicLong counter;

	public HelloWorldResource(String template, String defaultName) {
		this.template = template;
		this.defaultName = defaultName;
		this.counter = new AtomicLong();
	}

	public SayingRepresentaion sayHello(
			@QueryParam("name") Optional<String> name) {
		return new SayingRepresentaion(counter.incrementAndGet(),
				String.format(template, name.or(defaultName)));
	}
}

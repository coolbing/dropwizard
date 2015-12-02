package com.dropwizard;

public class SayingRepresentaion {

	private long id;

	private String content;

	public SayingRepresentaion(long id, String content) {
		this.id = id;
		this.content = content;
	}

	public long getId() {
		return id;
	}

	public String getContent() {
		return content;
	}

}

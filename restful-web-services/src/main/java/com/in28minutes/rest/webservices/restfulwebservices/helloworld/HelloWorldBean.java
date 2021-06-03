package com.in28minutes.rest.webservices.restfulwebservices.helloworld;

public class HelloWorldBean  {

	private String message;
	
	private String test;

	public HelloWorldBean(String message)
	{
		this.message = message;
		this.test = "test";
	}

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}

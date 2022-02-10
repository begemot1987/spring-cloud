package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.HelloWorldBean;

@RestController
public class DemoController {
	
	@GetMapping
	public HelloWorldBean test() {
		return new HelloWorldBean("Hello world");
	}
}

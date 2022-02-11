package com.example.demo.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.HelloWorldBean;

@RestController
public class DemoController {
	@Autowired
	private MessageSource messageSource;
	
	@GetMapping("/hello")
	public HelloWorldBean test() {
		return new HelloWorldBean("Hello world");
	}
	
	@GetMapping("/hello-int")
	public String helloWorldInternationalized() {
		return messageSource.getMessage("hello.world.message", null, "Default message", LocaleContextHolder.getLocale());
	}
}

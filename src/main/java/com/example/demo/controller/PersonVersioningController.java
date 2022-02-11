package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.versioning.Name;
import com.example.demo.versioning.PersonV1;
import com.example.demo.versioning.PersonV2;

@RestController
public class PersonVersioningController {
	/*versioning by diferent url*/
	@GetMapping("v1/person")
	public PersonV1 getV1() {
		return new PersonV1("John Bobko");
	}
	
	@GetMapping("v2/person")
	public PersonV2 getV2() {
		return new PersonV2(new Name("Alice", "Cooper"));
	}
	
	/*versioning using params localhost:8080/person/param?version= 1 or 2*/
	
	@GetMapping(value = "/person/param", params = "version=1")
	public PersonV1 paramV1() {
		return new PersonV1("John Bobko");
	}
	
	@GetMapping(value = "/person/param", params = "version=2")
	public PersonV2 paramV2() {
		return new PersonV2(new Name("Alice", "Cooper"));
	}
	
	/*versioning using headers localhost:8080/person/header headers-> key = X-API-VERSION, value = 1 or 2*/
	@GetMapping(value = "/person/header", headers = "X-API-VERSION=1")
	public PersonV1 headerV1() {
		return new PersonV1("John Bobko");
	}
	
	@GetMapping(value = "/person/header", headers = "X-API-VERSION=2")
	public PersonV2 headerV2() {
		return new PersonV2(new Name("Alice", "Cooper"));
	}
	
	/*versioning using produces localhost:8080/person/produces headers-> key = Accept, value = application/vnd.company.app-v1+json*/
	@GetMapping(value = "/person/produces", produces = "application/vnd.company.app-v1+json")
	public PersonV1 producesV1() {
		return new PersonV1("John Bobko");
	}
	
	@GetMapping(value = "/person/produces", produces = "application/vnd.company.app-v2+json")
	public PersonV2 producesV2() {
		return new PersonV2(new Name("Alice", "Cooper"));
	}
}

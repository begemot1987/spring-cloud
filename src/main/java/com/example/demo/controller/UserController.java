package com.example.demo.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.dao.UserDao;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.User;

@RestController
public class UserController {
	private final UserDao userDao;
	
	public UserController(UserDao userDao) {
		this.userDao = userDao;
	}
	
	@GetMapping("/users")
	public List<User> getAll() {
		return userDao.findAll();
	}
	
	@GetMapping("/users/{id}")
	public EntityModel<User> findById(@PathVariable Long id) {
		User user = userDao.findById(id);
		if (user == null) {
			throw new UserNotFoundException("There is no user with such id:" + id);		}
		EntityModel<User> model = EntityModel.of(user);
		WebMvcLinkBuilder linkToUsers = linkTo(methodOn(this.getClass()).getAll());
		model.add(linkToUsers.withRel("all-users"));		
		return model;
	}
	
	@DeleteMapping("users/delete/{id}")
	public void delete(@PathVariable Long id) {
		userDao.deleteById(id);
	}
	
	@PostMapping("/users")
	public ResponseEntity<Object> save(@Valid @RequestBody User user) {
		User savedUser = userDao.save(user);		
		URI location = ServletUriComponentsBuilder
		.fromCurrentRequest()
		.path("/{id}")
		.buildAndExpand(savedUser.getId()).toUri();		
		return ResponseEntity.created(location).build();
	}
	
}

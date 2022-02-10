package com.example.demo.dao;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

import com.example.demo.model.User;

@Component
public class UserDao {
	private static ArrayList<User> users = new ArrayList<>();
	private static Long index = 3L;
	
	
	static {
		users.add(new User(1L, "Bob", new Date()));
		users.add(new User(2L, "Alice", new Date()));
		users.add(new User(3L, "John", new Date()));		
	}	
	
	public List<User> findAll() {
		return users;
	}
	
	public User findById(Long id) {
		for(User user : users) {
			if (user.getId() == id) {
				return user;
			}			
		}
		return null;
	}
	
	public User save(User user) {
		if (user.getId() == null) {
			user.setId(++index);
		}
		users.add(user);
		return user;
		
	}
	
	public void deleteById(Long id) {
		Iterator<User> iterator = users.iterator();
		while (iterator.hasNext()) {
			User user = iterator.next();
			if (user.getId() == id) {
				iterator.remove();
			}
		}
	}
}

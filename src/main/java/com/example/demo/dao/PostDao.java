package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.Post;

public class PostDao {
	private static ArrayList<Post> posts = new ArrayList();
	
	static {
		posts.add(new Post(1L, "Firs post", "Some post about nothing"));
		posts.add(new Post(2L, "Second post", "Some post about nothing"));
		posts.add(new Post(3L, "Third post", "Some post about nothing"));
		posts.add(new Post(4L, "Fourth post", "Some post about nothing"));
		posts.add(new Post(5L, "Fifth post", "Some post about nothing"));
	}
	
	public List<Post> findAll() {
		return posts;		
	}
	
	public Post findById(Long id) {
		for(Post post : posts) {
			if (post.getId() == id) {
				return post;
			}
		}
		return null;
	}
	
	public void someMethod() {
		
	}
}

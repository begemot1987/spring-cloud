package com.example.demo.model;

public class Post {
	private Long id;
	private String title;
	private String article;
	
	public Post(Long id, String title, String article) {
		this.id = id;
		this.title = title;
		this.article = article;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArticle() {
		return article;
	}

	public void setArticle(String article) {
		this.article = article;
	}
}

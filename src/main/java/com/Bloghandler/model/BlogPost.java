package com.Bloghandler.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//BlogPost.java

@Entity
@Table(name = "blog_posts")
public class BlogPost {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String title;

	private String content;

	private LocalDateTime publishedAt;

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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDateTime getPublishedAt() {
		return publishedAt;
	}

	public void setPublishedAt(LocalDateTime publishedAt) {
		this.publishedAt = publishedAt;
	}

	public BlogPost(Long id, String title, String content, LocalDateTime publishedAt) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.publishedAt = publishedAt;
	}

	public BlogPost() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "BlogPost [id=" + id + ", title=" + title + ", content=" + content + ", publishedAt=" + publishedAt
				+ "]";
	}

// getters and setters

}

package com.Bloghandler.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Bloghandler.model.BlogPost;
import com.Bloghandler.service.BlogPostService;

@RestController
@RequestMapping("/blog-posts")
public class BlogPostController {

	@Autowired
	private final BlogPostService blogPostService;

	public BlogPostController(BlogPostService blogPostService) {
		this.blogPostService = blogPostService;
	}

	@GetMapping("/")
	public Iterable<BlogPost> getAllBlogPosts() {
		return blogPostService.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<BlogPost> getBlogPostById(@PathVariable Long id) {
		Optional<BlogPost> blogPost = blogPostService.findById(id);
		if (blogPost.isPresent()) {
			return ResponseEntity.ok(blogPost.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping("/")
	public ResponseEntity<BlogPost> createBlogPost(@RequestBody BlogPost blogPost) {
		BlogPost savedBlogPost = blogPostService.save(blogPost);
		return ResponseEntity.ok(savedBlogPost);
	}

	@PutMapping("/{id}")
	public ResponseEntity<BlogPost> updateBlogPost(@PathVariable Long id, @RequestBody BlogPost blogPost) {
		Optional<BlogPost> existingBlogPost = blogPostService.findById(id);
		if (existingBlogPost.isPresent()) {
			blogPost.setId(id);
			BlogPost savedBlogPost = blogPostService.save(blogPost);
			return ResponseEntity.ok(savedBlogPost);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteBlogPost(@PathVariable Long id) {
		Optional<BlogPost> existingBlogPost = blogPostService.findById(id);
		if (existingBlogPost.isPresent()) {
			blogPostService.deleteById(id);
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();
		}

	}
}

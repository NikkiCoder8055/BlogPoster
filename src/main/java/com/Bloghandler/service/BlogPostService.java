package com.Bloghandler.service;

import java.util.Optional;

import com.Bloghandler.model.BlogPost;

//BlogPostService.java

public interface BlogPostService {
	
	 Iterable<BlogPost> findAll();

	Optional<BlogPost> findById(Long id);

	BlogPost save(BlogPost blogPost);

	void deleteById(Long id);
}

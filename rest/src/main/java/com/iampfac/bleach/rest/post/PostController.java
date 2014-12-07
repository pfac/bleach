package com.iampfac.bleach.rest.post;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iampfac.bleach.core.blog.Blog;
import com.iampfac.bleach.core.post.Post;

@RestController
@RequestMapping("/posts")
public class PostController {

	private Blog blog;

	@Autowired
	public PostController(Blog blog) {
		this.blog = blog;
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<Post> getPosts() {
		return blog.getPosts();
	}
}

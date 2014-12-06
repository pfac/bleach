package com.iampfac.bleach.rest.post;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iampfac.bleach.core.post.Post;

@RestController
@RequestMapping("/posts")
public class PostController {

	@RequestMapping(method = RequestMethod.GET)
	public Post getPosts() {
		return new Post();
	}
}

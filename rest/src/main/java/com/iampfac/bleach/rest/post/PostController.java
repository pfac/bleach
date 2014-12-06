package com.iampfac.bleach.rest.post;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posts")
public class PostController {

	@RequestMapping(method = RequestMethod.GET)
	public void getPosts() {
	}
}

package com.iampfac.bleach.core.blog;

import java.util.List;

import com.iampfac.bleach.core.post.Post;
import com.iampfac.bleach.core.post.PostRepository;
import com.iampfac.bleach.core.post.PostService;

/**
 * Service class at the root of the application.
 * 
 * @author Pedro Costa<dev@iampfac.com>
 *
 */
public class Blog implements PostService {

	private PostRepository postRepository;

	public Blog(PostRepository postRepository) {
		this.postRepository = postRepository;
	}

	public List<Post> getPosts() {
		return postRepository.getAllPosts();
	}
}

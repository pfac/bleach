package com.iampfac.bleach.data.jpa.post;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iampfac.bleach.core.post.Post;
import com.iampfac.bleach.core.post.PostRepository;

@Repository
public class JpaAdapterPostRepository implements PostRepository {

	private PostJpaRepository repository;

	@Autowired
	public JpaAdapterPostRepository(PostJpaRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<Post> getAllPosts() {
		final List<PostJpaEntity> entities = repository.findAll();

		List<Post> posts = new ArrayList<Post>(entities.size());
		for (PostJpaEntity entity : entities) {
			final Post post = entity.toPost();
			posts.add(post);
		}

		return posts;
	}

}

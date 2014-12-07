package com.iampfac.bleach.test.data.jpa.post;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import com.iampfac.bleach.core.post.Post;
import com.iampfac.bleach.data.jpa.post.PostJpaEntity;

public class PostJpaEntityBuilder {

	private static AtomicLong counter = new AtomicLong();

	public static PostJpaEntity build() {
		final Long id = counter.incrementAndGet();
		PostJpaEntity entity = new PostJpaEntity();
		entity.setId(id);
		return entity;
	}

	public static List<PostJpaEntity> build(final int size) {
		List<PostJpaEntity> entities = new ArrayList<PostJpaEntity>(size);
		for (int i = 0; i < size; ++i) {
			final PostJpaEntity entity = build();
			entities.add(entity);
		}
		return entities;
	}

	public static List<PostJpaEntity> build(final List<Post> posts) {
		final int size = posts.size();
		List<PostJpaEntity> entities = new ArrayList<PostJpaEntity>(size);
		for (Post post : posts) {
			final PostJpaEntity entity = new PostJpaEntity(post);
			entities.add(entity);
		}
		return entities;
	}
}

package com.iampfac.bleach.test.core.post;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import com.iampfac.bleach.core.post.Post;

public class PostBuilder {

	private static AtomicLong counter = new AtomicLong();

	public static Post build() {
		final Long id = counter.incrementAndGet();
		Post post = new Post();
		post.setId(id);
		return post;
	}

	public static List<Post> build(final int size) {
		List<Post> posts = new ArrayList<Post>(size);
		for (int i = 0; i < size; ++i) {
			final Post post = build();
			posts.add(post);
		}
		return posts;
	}
}

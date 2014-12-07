package com.iampfac.bleach.test.data.jpa.post;

import org.apache.commons.lang3.RandomUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.iampfac.bleach.core.post.Post;
import com.iampfac.bleach.data.jpa.post.PostJpaEntity;
import com.iampfac.bleach.test.core.post.PostBuilder;

public class PostJpaEntityUnitTest {

	private PostJpaEntity entity;

	@Before
	public void setup() {
		final Long id = RandomUtils.nextLong(1, 1000);
		entity = new PostJpaEntity();
		entity.setId(id);
	}

	@Test
	public void itHasPropertyId() {
		final Long id = RandomUtils.nextLong(1, 1000);
		entity.setId(id);
		Assert.assertEquals(id, entity.getId());
	}

	@Test
	public void constructorPost_createsEntityWithSameId() {
		final Post post = PostBuilder.build();
		final PostJpaEntity entity = new PostJpaEntity(post);
		Assert.assertEquals(post.getId(), entity.getId());
	}

	@Test
	public void toPost_createsPostWithSameId() {
		final Post post = entity.toPost();
		Assert.assertEquals(entity.getId(), post.getId());
	}
}

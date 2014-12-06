package com.iampfac.bleach.test.core.post;

import org.apache.commons.lang3.RandomUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.iampfac.bleach.core.post.Post;

public class PostUnitTest {

	private Post post;

	@Before
	public void setup() {
		this.post = new Post();
	}

	@Test
	public void itHasPropertyId() {
		final Long id = RandomUtils.nextLong(1, 1000);
		post.setId(id);
		Assert.assertEquals(id, post.getId());
	}

}

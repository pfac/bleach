package com.iampfac.bleach.test.core.post;

import org.apache.commons.lang3.RandomUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.iampfac.bleach.core.post.Post;

public class PostUnitTest {

	private Post post;

	public static Post post() {
		final long id = RandomUtils.nextLong(1, 1000);

		Post post = new Post();
		post.setId(id);

		return post;
	}

	@Before
	public void setup() {
		this.post = post();
	}

	@Test
	public void itHasPropertyId() {
		final Long id = RandomUtils.nextLong(1, 1000);
		post.setId(id);
		Assert.assertEquals(id, post.getId());
	}

	@Test
	public void equalsObject_returnsTrueIfComparedWithItself() {
		final Object obj = post;
		Assert.assertTrue(obj.equals(obj));
	}

	@Test
	public void equalsObject_returnsFalseIfComparedWithNull() {
		final Object obj = post;
		Assert.assertFalse(obj.equals(null));
	}

	@Test
	public void equalsObject_returnsFalseIfIsNotInstanceOfPost() {
		final Object obj = post;
		final Object other = "not a post";
		Assert.assertFalse(obj.equals(other));
	}

	@Test
	public void equalsObject_callsEqualsPostIfIsInstanceOfPost() {
		final Object obj = post;
		final Object other = Mockito.spy(post());
		obj.equals(other);
		Mockito.verify(other).equals((Post) other);
	}

	@Test
	public void equalsPost_returnsFalseIfIdIsDifferent() {
		final Post other = post();
		Assert.assertFalse(post.equals(other));
	}
}

package com.iampfac.bleach.test.core.blog;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.iampfac.bleach.core.blog.Blog;
import com.iampfac.bleach.core.post.Post;
import com.iampfac.bleach.core.post.PostRepository;
import com.iampfac.bleach.test.core.post.PostUnitTest;

@RunWith(MockitoJUnitRunner.class)
public class BlogUnitTest {

	@Mock
	private PostRepository postRepository;

	@InjectMocks
	private Blog blog;

	@Test
	public void getPost_invokesPostRepository_getAllPosts() {
		blog.getPosts();
		Mockito.verify(postRepository).getAllPosts();
	}

	@Test
	public void getPost_returnsAllPosts() {
		final List<Post> expecteds = Arrays.asList(PostUnitTest.post(), PostUnitTest.post(), PostUnitTest.post());

		Mockito.when(postRepository.getAllPosts()).thenReturn(expecteds);
		final List<Post> actuals = blog.getPosts();

		Assert.assertEquals(expecteds, actuals);
	}
}

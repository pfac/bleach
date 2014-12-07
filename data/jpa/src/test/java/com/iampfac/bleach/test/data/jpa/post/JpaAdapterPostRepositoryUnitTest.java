package com.iampfac.bleach.test.data.jpa.post;

import java.util.List;

import org.apache.commons.lang3.RandomUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.iampfac.bleach.core.post.Post;
import com.iampfac.bleach.data.jpa.post.JpaAdapterPostRepository;
import com.iampfac.bleach.data.jpa.post.PostJpaEntity;
import com.iampfac.bleach.data.jpa.post.PostJpaRepository;
import com.iampfac.bleach.test.core.post.PostBuilder;

@RunWith(MockitoJUnitRunner.class)
public class JpaAdapterPostRepositoryUnitTest {

	@Mock
	private PostJpaRepository jpaRepository;

	@InjectMocks
	private JpaAdapterPostRepository repository;

	@Test
	public void getAllPosts_convertsJpaEntitiesToPosts() {
		final int size = RandomUtils.nextInt(5, 20);
		final List<Post> posts = PostBuilder.build(size);
		final List<PostJpaEntity> entities = PostJpaEntityBuilder.build(posts);

		Mockito.when(jpaRepository.findAll()).thenReturn(entities);

		Assert.assertEquals(posts, repository.getAllPosts());
	}
}

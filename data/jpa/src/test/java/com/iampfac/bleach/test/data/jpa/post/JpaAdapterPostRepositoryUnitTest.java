package com.iampfac.bleach.test.data.jpa.post;

import java.util.List;

import org.apache.commons.lang3.RandomUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.iampfac.bleach.core.post.Post;
import com.iampfac.bleach.data.jpa.post.JpaAdapterPostRepository;
import com.iampfac.bleach.data.jpa.post.PostJpaEntity;
import com.iampfac.bleach.data.jpa.post.PostJpaRepository;
import com.iampfac.bleach.test.core.post.PostBuilder;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {
	JpaAdapterPostRepositoryUnitTest.TextContext.class
})
public class JpaAdapterPostRepositoryUnitTest {

	@Configuration
	@ComponentScan("com.iampfac.bleach.data.jpa.post")
	protected static class TextContext {

		@Bean
		public PostJpaRepository jpaRepository() {
			return Mockito.mock(PostJpaRepository.class);
		}

		@Bean
		public JpaAdapterPostRepository repository(PostJpaRepository jpaRepository) {
			return new JpaAdapterPostRepository(jpaRepository);
		}

	}

	@Autowired
	private PostJpaRepository jpaRepository;

	@Autowired
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

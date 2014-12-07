package com.iampfac.bleach.test.rest.post;

import java.util.Arrays;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.iampfac.bleach.core.blog.Blog;
import com.iampfac.bleach.core.post.Post;
import com.iampfac.bleach.rest.post.PostController;
import com.iampfac.bleach.test.core.post.PostUnitTest;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {
	PostControllerUnitTest.TestContext.class
})
@WebAppConfiguration
public class PostControllerUnitTest {

	@Configuration
	protected static class TestContext {

		@Bean
		public Blog blog() {
			return Mockito.mock(Blog.class);
		}

		@Bean
		public PostController postController(Blog blog) {
			return new PostController(blog);
		}

	}

	private MockMvc mvc;

	@Autowired
	private Blog blog;

	@Autowired
	private PostController controller;

	@Before
	public void setup() {
		mvc = MockMvcBuilders.standaloneSetup(controller).build();
	}

	@Test
	public void getPostsReturnsHttpOk() throws Exception {
		final MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/posts");
		final ResultMatcher statusToBeOk = MockMvcResultMatchers.status()
				.isOk();

		mvc.perform(request).andExpect(statusToBeOk);
	}

	@Test
	public void getPostsReturnsJsonContent() throws Exception {
		final MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/posts");
		final ResultMatcher contentToBeJson = MockMvcResultMatchers.content()
				.contentType("application/json;charset=UTF-8");

		mvc.perform(request).andExpect(contentToBeJson);
	}

	@Test
	public void getPostsReturnsArrayWithAllPostsData() throws Exception {
		final Post post1 = PostUnitTest.post();
		final Post post2 = PostUnitTest.post();
		final Post post3 = PostUnitTest.post();

		final int post1id = post1.getId().intValue();
		final int post2id = post2.getId().intValue();
		final int post3id = post3.getId().intValue();

		final List<Post> posts = Arrays.asList(post1, post2, post3);

		Mockito.when(blog.getPosts()).thenReturn(posts);

		final MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/posts");
		final ResultMatcher contentToBeAnArray = MockMvcResultMatchers.jsonPath("$")
				.isArray();
		final ResultMatcher contentToHaveThreeItems = MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(posts.size()));

		final ResultMatcher contentFirstToBePostOne = MockMvcResultMatchers.jsonPath("$[0].id")
				.value(post1id);
		final ResultMatcher contentSecondToBePostTwo = MockMvcResultMatchers.jsonPath("$[1].id")
				.value(post2id);
		final ResultMatcher contentThirdToBePostThree = MockMvcResultMatchers.jsonPath("$[2].id")
				.value(post3id);

		mvc.perform(request)
				.andExpect(contentToBeAnArray)
				.andExpect(contentToHaveThreeItems)
				.andExpect(contentFirstToBePostOne)
				.andExpect(contentSecondToBePostTwo)
				.andExpect(contentThirdToBePostThree);
	}
}

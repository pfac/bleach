package com.iampfac.bleach.test.rest.post;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
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

import com.iampfac.bleach.rest.post.PostController;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PostControllerUnitTest.TestContext.class })
@WebAppConfiguration
public class PostControllerUnitTest {

	@Configuration
	protected static class TestContext {

		@Bean
		public PostController postController() {
			return new PostController();
		}

	}

	private MockMvc mvc;

	@Autowired
	private PostController controller;

	@Before
	public void setup() {
		mvc = MockMvcBuilders.standaloneSetup(controller).build();
	}

	@Test
	public void getPostsReturnsHttpOk() throws Exception {
		final MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/posts");
		final ResultMatcher statusToBeOk = MockMvcResultMatchers.status().isOk();

		mvc.perform(request).andExpect(statusToBeOk);
	}

	@Test
	public void getPostsReturnsJsonContent() throws Exception {
		final MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/posts");
		final ResultMatcher contentToBeJson = MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8");

		mvc.perform(request).andExpect(contentToBeJson);
	}
}

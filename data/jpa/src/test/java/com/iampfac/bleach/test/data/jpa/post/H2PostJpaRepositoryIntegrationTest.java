package com.iampfac.bleach.test.data.jpa.post;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.iampfac.bleach.data.jpa.H2JpaDatabaseBleachContext;
import com.iampfac.bleach.data.jpa.post.PostJpaEntity;
import com.iampfac.bleach.data.jpa.post.PostJpaRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { H2JpaDatabaseBleachContext.class })
public class H2PostJpaRepositoryIntegrationTest {

	@Autowired
	private PostJpaRepository repository;

	@Test
	public void save_generatesId() {
		PostJpaEntity entity = new PostJpaEntity();
		entity = repository.save(entity);
		Assert.assertNotNull(entity.getId());
	}

}

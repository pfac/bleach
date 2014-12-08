package com.iampfac.bleach.data.jpa.post;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.iampfac.bleach.core.post.Post;

@Entity
@Table(name = "posts")
public class PostJpaEntity {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;

	public PostJpaEntity() {
	}

	public PostJpaEntity(final Post post) {
		setId(post.getId());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	//
	// conversion
	//

	public Post toPost() {
		Post post = new Post();
		post.setId(getId());
		return post;
	}

}

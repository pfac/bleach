package com.iampfac.bleach.core.post;

import java.util.Objects;

public class Post {

	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	//
	// comparison
	//

	public boolean equals(Post other) {
		return Objects.equals(getId(), other.getId());
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (obj != null) {
			if (obj instanceof Post) {
				final Post post = (Post) obj;
				return equals(post);
			}
		}
		return false;
	}
}

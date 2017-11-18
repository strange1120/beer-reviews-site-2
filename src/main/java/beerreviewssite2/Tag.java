package beerreviewssite2;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Tag {

	@Id
	@GeneratedValue
	private Long id;
	private String tag;

	public Long getId() {
		return id;
	}

	public String getTag() {
		return tag;
	}

	@ManyToMany(mappedBy = "tags")
	private Set<Review> reviewList;

	public Set<Review> getReviewList() {
		return reviewList;
	}

	protected Tag() {

	}

	public Tag(String tag) {
		this.tag = tag;
	}
}

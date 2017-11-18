package beerreviewssite2;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Style {

	@Id
	@GeneratedValue
	private Long id;

	private String style;

	@OneToMany(mappedBy = "style")
	private Set<Review> reviewList;

	public Long getId() {
		return id;
	}

	public Set<Review> getReviewList() {
		return reviewList;
	}

	public String getStyle() {
		return style;
	}

	protected Style() {

	}

	public Style(String style) {
		this.style = style;
	}

}
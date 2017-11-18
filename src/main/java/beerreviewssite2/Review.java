package beerreviewssite2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Review {

	@Id
	@GeneratedValue
	private Long id;
	private String beerName;
	private String breweryName;
	private String imageUrl;
	@Lob
	private String beerReview;

	@ManyToOne
	private Style style;

	@ManyToMany
	private Set<Tag> tags;

	protected Review() {

	}

	public Long getId() {
		return id;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public String getBreweryName() {
		return breweryName;
	}

	public String getBeerReview() {
		return beerReview;
	}

	public String getBeerName() {
		return beerName;
	}

	public Style getStyle() {
		return style;
	}

	public Set<Tag> getTags() {
		return tags;
	}

	public void addTag(Tag tag) {
		tags.add(tag);
	}

	public void removeTag(Tag tag) {
		tags.remove(tag);
	}

	public Review(Set<Tag> tags) {
		this.tags = tags;
	}

	public Review(String beerReview, String beerName, String breweryName, String imageUrl, Style style, Tag... tags) {
		this.beerReview = beerReview;
		this.beerName = beerName;
		this.breweryName = breweryName;
		this.imageUrl = imageUrl;
		this.style = style;
		this.tags = new HashSet<Tag>(Arrays.asList(tags));
	}

}

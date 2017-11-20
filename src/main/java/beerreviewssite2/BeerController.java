package beerreviewssite2;

import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BeerController {

	@Resource
	ReviewRepository reviewRepo;

	@Resource
	TagRepository tagRepo;

	@Resource
	StyleRepository styleRepo;

	@RequestMapping("/tags")
	public String showAllTags(Model model) {
		model.addAttribute("tags", tagRepo.findAll());
		return "tags";
	}

	@RequestMapping("/styles")
	public String showAllStyles(Model model) {
		model.addAttribute("styles", styleRepo.findAll());
		return "styles";
	}

	@RequestMapping("/reviews")
	public String showAllReviews(Model model) {
		model.addAttribute("reviews", reviewRepo.findAll());
		return "reviews";
	}

	@RequestMapping("/tag")
	public String showOneTag(@RequestParam Long id, Model model) {
		model.addAttribute("tag", tagRepo.findOne(id));
		return "tag";

	}

	@RequestMapping("/style")
	public String showOneStyle(@RequestParam Long id, Model model) {
		model.addAttribute("style", styleRepo.findOne(id));
		return "style";

	}

	@RequestMapping("/review")
	public String showOneReview(@RequestParam Long id, Model model) {
		model.addAttribute("review", reviewRepo.findOne(id));
		return "review";
	}

	@RequestMapping("/add-tag")
	public String addTag(@RequestParam(value = "id") Long id, String tag) {
		if (!tag.equals("")) {
			Tag tagCreation = tagRepo.findByTag(tag);
			if (tagCreation == null) {
				tagCreation = new Tag(tag);
				tagRepo.save(tagCreation);
			}
			Review review = reviewRepo.findOne(id);
			Set<Tag> reviewTags = review.getTags();
			if (!reviewTags.contains(tagCreation)) {
				review.addTag(tagCreation);
				reviewRepo.save(review);
			}
		}
		return "redirect:/review?id=" + id;
	}

	@RequestMapping("/remove-tag")
	public String removeTag(@RequestParam Long tagId, @RequestParam Long reviewId) {
		Tag deleteTag = tagRepo.findOne(tagId);
		Review review = reviewRepo.findOne(reviewId);
		review.removeTag(deleteTag);
		reviewRepo.save(review);
		return "redirect:/review?id=" + reviewId;
	}

	@RequestMapping("/")
	public String showAllClasses(Model model) {
		model.addAttribute("styles", styleRepo.findAll());
		model.addAttribute("tags", tagRepo.findAll());
		model.addAttribute("reviews", reviewRepo.findAll());
		return "splashPage";
	}

}

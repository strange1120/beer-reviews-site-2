package beerreviewssite2;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BeerPopulator implements CommandLineRunner {

	@Resource
	private ReviewRepository reviewRepo;

	@Resource
	private TagRepository tagRepo;

	@Resource
	private StyleRepository styleRepo;

	@Override
	public void run(String... args) throws Exception {
		Tag sweet = new Tag("Sweet");
		tagRepo.save(sweet);
		Tag coffee = new Tag("Coffee");
		tagRepo.save(coffee);
		Tag dark = new Tag("Dark");
		tagRepo.save(dark);
		Tag smooth = new Tag("Smooth");
		tagRepo.save(smooth);
		Tag rich = new Tag("Rich");
		tagRepo.save(rich);
		Tag tart = new Tag("Tart");
		tagRepo.save(tart);
		Tag fruity = new Tag("Fruity");
		tagRepo.save(fruity);
		Tag light = new Tag("Light");
		tagRepo.save(light);
		Tag mango = new Tag("Mango");
		tagRepo.save(mango);
		Tag vanilla = new Tag("Vanilla");
		tagRepo.save(vanilla);
		Tag hoppy = new Tag("Hoppy");
		tagRepo.save(hoppy);
		Tag thin = new Tag("Thin");
		tagRepo.save(thin);
		Tag roasty = new Tag("Roasty");
		tagRepo.save(roasty);
		Tag strong = new Tag("Strong");
		tagRepo.save(strong);
		Tag herbal = new Tag("Herbal");
		tagRepo.save(herbal);
		Style stout = new Style("Stout");
		styleRepo.save(stout);
		Style sour = new Style("Sour");
		styleRepo.save(sour);
		Style saison = new Style("Saison");
		styleRepo.save(saison);
		Style ipa = new Style("IPA");
		styleRepo.save(ipa);
		Style porter = new Style("Porter");
		styleRepo.save(porter);
		Review review1 = new Review(
				"Drinking this at 2am as I finish my project. Being a degnerate and drinking out of a can instead of a glass. A solid imperial IPA from omnipollo. Very strong.",
				"Nebuchadnezzar", "Omnipollo", "./images/omnipollo.jpg", ipa, hoppy, strong, fruity, sweet, smooth);
		reviewRepo.save(review1);
		Review review2 = new Review(
				"I'm not gonna lie. I didn't get around to trying this one this weekend for work's sake.", "Voltan",
				"Hoof Hearted", "./images/voltan.jpg", stout, coffee, roasty, dark, smooth, thin);
		reviewRepo.save(review2);
		Review review3 = new Review(
				"Holy sweet. I think that Urban Artifact overdid it with the blackberries. Vanilla taste did come through though. Super heavy. Could not drink more than one in one sitting.",
				"Operation Plowshare", "Urban Artifact", "./images/operation.jpg", sour, tart, vanilla, sweet, smooth);
		reviewRepo.save(review3);
		Review review4 = new Review(
				"This was nothing special. Supposed to be aged on cedar but I definitely didn't taste cedar. Overall it was ok. Would not drink again.",
				"G 13", "Stillwater", "./images/g13.jpg", ipa, hoppy, tart, light, fruity);
		reviewRepo.save(review4);
		Review review5 = new Review(
				"I LOVED this beer. Hoof Hearted never disappoints. All around well-balanced. Everything I want in a sour beer. It was gone within 5 minutes.",
				"Skin Froot", "Hoof Hearted", "./images/skinfroot.jpg", sour, tart, fruity, light, mango);
		reviewRepo.save(review5);
		Review review6 = new Review(
				"This was good but definitely wish I had not spent $9.00 on it. It taste's like straight booze. I drank it on Saturday night and it put me on my ass.",
				"Imperial Doughnut Break", "Evil Twin", "./images/imperialbreak.jpg", porter, sweet, coffee, dark,
				smooth, rich);
		reviewRepo.save(review6);
		Review review7 = new Review(
				"I think this was one of my favorite's of this weekend. Very effervescent and easy to drink. Probably was finished with it in five minutes or less. Whoops.",
				"Ground Loop", "Stillwater, Two Road's", "./images/groundloop.png", saison, tart, light, herbal);
		reviewRepo.save(review7);

	}
}

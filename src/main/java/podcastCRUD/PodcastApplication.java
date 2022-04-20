package podcastCRUD;

import org.slf4j.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import podcastCRUD.domain.Category;
import podcastCRUD.domain.CategoryRepository;
import podcastCRUD.domain.Platform;
import podcastCRUD.domain.PlatformRepository;
import podcastCRUD.domain.Podcast;
import podcastCRUD.domain.PodcastRepository;
import podcastCRUD.domain.Sponsor;
import podcastCRUD.domain.SponsorRepository;
import podcastCRUD.domain.User;
import podcastCRUD.domain.UserRepository;

@SpringBootApplication
public class PodcastApplication {
	private static final Logger log = LoggerFactory.getLogger(PodcastApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(PodcastApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner podcastDemo(PodcastRepository podrepository, CategoryRepository catrepository, 
			SponsorRepository sponsrepository, PlatformRepository platrepository, UserRepository userrepository) {
		return (args) -> {
			log.info("save a couple of podcasts");
			
			Category humor = new Category("Humor");
			catrepository.save(humor);
			Category cultureAndSociety = new Category("Culture and Society");
			catrepository.save(cultureAndSociety);
			Category trueCrime = new Category("True Crime");
			catrepository.save(trueCrime);
			
			Sponsor asennemedia = new Sponsor("Asennemedia");
			sponsrepository.save(asennemedia);
			Sponsor podme = new Sponsor("Podme");
			sponsrepository.save(podme);
			
			Platform spotify = new Platform("Spotify");
			platrepository.save(spotify);
			Platform podmePrerium = new Platform("Podme Prerium");
			platrepository.save(podmePrerium);

			podrepository.save(new Podcast("Afterwork", "Meri Milash, Jenni Rotonen, Petra Väänänen", asennemedia, cultureAndSociety, spotify));
			podrepository.save(new Podcast("Tuplakääk", "Enni Koistinen, Kirsikka Simberg", podme, humor, podmePrerium));
			podrepository.save(new Podcast("Jäljillä", "Tilda Laaksonen", asennemedia, trueCrime, spotify));
			
			User hannamariadmin = new User("hannamari", "$2a$10$mtnl7i9dzsDwRpyis5tkH.jPTG7QPP9NRH.molNiSUiyxXfq92pfG",
					"ADMIN");
	

			userrepository.save(hannamariadmin);
			
			
			log.info("fetch all podcasts");
			for (Podcast podcast : podrepository.findAll()) {
				log.info(podcast.toString());
			}
		};
	}
}

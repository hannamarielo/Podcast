package podcastCRUD;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import podcastCRUD.domain.Category;
import podcastCRUD.domain.CategoryRepository;
import podcastCRUD.domain.Platform;
import podcastCRUD.domain.PlatformRepository;
import podcastCRUD.domain.Podcast;
import podcastCRUD.domain.PodcastRepository;
import podcastCRUD.domain.Sponsor;
import podcastCRUD.domain.SponsorRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class PodcastRepositoryTest {

	@Autowired
	private PodcastRepository podrepository;

	@Autowired
	private CategoryRepository catrepository;

	@Autowired
	private SponsorRepository sponsrepository;

	@Autowired
	private PlatformRepository platrepository;

	@Test
	public void findPodcastByNameTest() {
		List<Podcast> podcasts = podrepository.findBypodcastname("Jäljillä");

		assertThat(podcasts).hasSize(1);
		assertThat(podcasts.get(0).getHosts()).isEqualTo("Tilda Laaksonen");
	}

	public void createNewPodcast() {
		
		Category literary = new Category("Literary");
		catrepository.save(literary);
		
		Sponsor podplay = new Sponsor("Podplay");
		sponsrepository.save(podplay);
		
		Platform podplayplat = new Platform("Podplay");
		platrepository.save(podplayplat);
		
		Podcast podcast = new Podcast("Sivumennen", "Johanna Laitinen, Jonna Tapanainen", podplay, literary, podplayplat);
		assertThat(podcast.getId()).isNotNull();
	}
}

package podcastCRUD;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import podcastCRUD.web.PodcastController;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class PodcastApplicationTests {

	@Autowired
	private PodcastController podcastcontroller;

	@Test
	public void contextLoads() {
		assertThat(podcastcontroller).isNotNull();
	}

}


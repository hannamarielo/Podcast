package podcastCRUD.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface PodcastRepository extends CrudRepository<Podcast, Long>{

	List<Podcast> findBypodcastname(String podcastname);
}

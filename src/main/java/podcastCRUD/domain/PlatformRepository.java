package podcastCRUD.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface PlatformRepository extends CrudRepository<Platform, Long>{

	List<Platform> findByplatformname(String platformname);
}

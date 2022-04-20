package podcastCRUD.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface SponsorRepository extends CrudRepository<Sponsor, Long>{

	List<Sponsor> findBysponsorname(String sponsorname);
}

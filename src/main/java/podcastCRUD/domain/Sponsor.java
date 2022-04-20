package podcastCRUD.domain;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "sponsor")
public class Sponsor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long sponsorid;

	private String sponsorname;

	@JsonIgnoreProperties("sponsor")
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "sponsor", fetch = FetchType.LAZY)
	private List<Podcast> podcasts;

	public Sponsor() {
		super();
		this.sponsorname = null;
	}

	public Sponsor(String sponsorname) {
		super();
		this.sponsorname = sponsorname;
	}

	public void setSponsorid(Long sponsorid) {
		this.sponsorid = sponsorid;
	}

	public void setSponsorname(String sponsorname) {
		this.sponsorname = sponsorname;
	}

	public void setPodcasts(List<Podcast> podcasts) {
		this.podcasts = podcasts;
	}

	public Long getSponsorid() {
		return sponsorid;
	}

	public String getSponsorname() {
		return sponsorname;
	}

	public List<Podcast> getPodcasts() {
		return podcasts;
	}

	@Override
	public String toString() {
		return "Sponsor [sponsorid=" + sponsorid + ", sponsorname=" + sponsorname + "]";
	}

}

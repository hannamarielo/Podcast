package podcastCRUD.domain;

import javax.persistence.*;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Podcast {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String podcastname;

	private String hosts;

	@JsonIgnoreProperties("podcasts")
	@ManyToOne
	@JoinColumn(name = "sponsorid")
	private Sponsor sponsor;
	
	@JsonIgnoreProperties("podcasts")
	@ManyToOne
	@JoinColumn(name = "categoryid")
	private Category category;
 
	@JsonIgnoreProperties("podcasts")
	@ManyToOne
	@JoinColumn(name = "platformid")
	private Platform platform;

	public Podcast() {
		super();
		this.podcastname = null;
		this.hosts = null;
		this.sponsor = null;
		this.category = null;
		this.platform = null;
	}

	public Podcast(String podcastname, String hosts, Sponsor sponsor, Category category,
			Platform platform) {
		super();
		this.podcastname = podcastname;
		this.hosts = hosts;
		this.sponsor = sponsor;
		this.category = category;
		this.platform = platform;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setPodcastname(String podcastname) {
		this.podcastname = podcastname;
	}

	public void setHosts(String hosts) {
		this.hosts = hosts;
	}

	public void setSponsor(Sponsor sponsor) {
		this.sponsor = sponsor;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public void setPlatform(Platform platform) {
		this.platform = platform;
	}

	public Long getId() {
		return id;
	}

	public String getPodcastname() {
		return podcastname;
	}

	public String getHosts() {
		return hosts;
	}

	public Sponsor getSponsor() {
		return sponsor;
	}

	public Category getCategory() {
		return category;
	}

	public Platform getPlatform() {
		return platform;
	}

	@Override
	public String toString() {
		if (this.sponsor != null && this.category != null && this.platform != null)
			return "Podcast [podcastid=" + id + ", podcastname=" + podcastname + ", hosts=" + hosts + ", sponsor="
			+ this.getSponsor() + ", category=" + this.getCategory() + ", platform=" + this.getPlatform() + "]";
		else
			return "Podcast [podcastid=" + id + ", podcastname=" + podcastname + ", hosts=" + hosts + "]";
	}

}

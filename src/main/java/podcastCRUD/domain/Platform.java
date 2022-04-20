package podcastCRUD.domain;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "platform")
public class Platform {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long platformid;

	private String platformname;

	@JsonIgnoreProperties("platform")
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "platform", fetch = FetchType.LAZY)
	private List<Podcast> podcasts;

	public Platform() {
		super();
		this.platformname = null;
	}

	public Platform(String platformname) {
		super();
		this.platformname = platformname;
	}

	public void setPlatformid(Long platformid) {
		this.platformid = platformid;
	}

	public void setPlatformname(String platformname) {
		this.platformname = platformname;
	}

	public void setPodcasts(List<Podcast> podcasts) {
		this.podcasts = podcasts;
	}

	public Long getPlatformid() {
		return platformid;
	}

	public String getPlatformname() {
		return platformname;
	}

	public List<Podcast> getPodcasts() {
		return podcasts;
	}

	@Override
	public String toString() {
		return "Platform [platformid=" + platformid + ", platformname=" + platformname + "]";
	}

}

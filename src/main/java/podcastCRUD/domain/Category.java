package podcastCRUD.domain;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "category")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long categoryid;

	private String categoryname;
	
	@JsonIgnoreProperties("category")
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "category", orphanRemoval = true)
	private List<Podcast> podcasts;

	public Category() {
		super();
		this.categoryname = null;
	}

	public Category(String categoryname) {
		super();
		this.categoryname = categoryname;
	}

	public void setCategoryid(Long categoryid) {
		this.categoryid = categoryid;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}

	public void setPodcasts(List<Podcast> podcasts) {
		this.podcasts = podcasts;
	}

	public Long getCategoryid() {
		return categoryid;
	}

	public String getCategoryname() {
		return categoryname;
	}

	public List<Podcast> getPodcasts() {
		return podcasts;
	}

	@Override
	public String toString() {
		return "Category [categoryid=" + categoryid + ", categoryname=" + categoryname + "]";
	}

}

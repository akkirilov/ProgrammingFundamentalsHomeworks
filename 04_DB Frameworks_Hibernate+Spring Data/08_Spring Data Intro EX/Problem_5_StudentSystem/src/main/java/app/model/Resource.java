package app.model;

import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "resourses")
public class Resource {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Basic
	private String name;
	
	@Basic
	private String type;
	
	@Basic
	private String url;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "resources_licenses")
	private Set<License> licenses;
	
	public Resource() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Set<License> getLicenses() {
		return licenses;
	}

	public void setLicenses(Set<License> licenses) {
		this.licenses = licenses;
	}
	
}

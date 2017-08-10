package app.domain.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "photographers")
public class Photographer implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "first_name")
	private String firstName;
	
	@NotNull
	@Length(min = 2, max = 50)
	@Column(name = "last_name")
	private String lastName;
	
	@Pattern(regexp = "\\+[0-9]{1,3}\\/[0-9]{8,10}")
	@Column(name = "phone")
	private String phone;

	@NotNull
	@OneToOne()
	@JoinColumn(name = "primary_camera")
	private Camera primaryCamera;

	@NotNull
	@OneToOne()
	@JoinColumn(name = "secondary_camera")
	private Camera secondaryCamera;
	
	@ManyToMany()
	@JoinTable(name = "photographers_lenses",
			joinColumns = @JoinColumn(name = "photographer_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "lens_id", referencedColumnName = "id"))
	private Set<Lens> lenses;
	
	@ManyToMany()
	@JoinTable(name = "photographers_accessories",
			joinColumns = @JoinColumn(name = "photographer_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "accessory_id", referencedColumnName = "id"))
	private Set<Accessory> accessories;

	public Photographer() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Camera getPrimaryCamera() {
		return primaryCamera;
	}

	public void setPrimaryCamera(Camera primaryCamera) {
		this.primaryCamera = primaryCamera;
	}

	public Camera getSecondaryCamera() {
		return secondaryCamera;
	}

	public void setSecondaryCamera(Camera secondaryCamera) {
		this.secondaryCamera = secondaryCamera;
	}

	public Set<Lens> getLenses() {
		return lenses;
	}

	public void setLenses(Set<Lens> lenses) {
		this.lenses = lenses;
	}

	public Set<Accessory> getAccessories() {
		return accessories;
	}

	public void setAccessories(Set<Accessory> accessories) {
		this.accessories = accessories;
	}
	
}

package app.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "labels")
public class ClassicLabel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Basic
    private String name;
    
    @Column(name = "sub_title")
    private String subTitle;

    @OneToOne(mappedBy = "label")
    private BasicShampoo basicShampoos;

    public ClassicLabel() {
    }

    public ClassicLabel(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	public String getSubTitle() {
		return subTitle;
	}

	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}

	public BasicShampoo getBasicShampoos() {
		return basicShampoos;
	}

	public void setBasicShampoos(BasicShampoo basicShampoos) {
		this.basicShampoos = basicShampoos;
	}
    
}

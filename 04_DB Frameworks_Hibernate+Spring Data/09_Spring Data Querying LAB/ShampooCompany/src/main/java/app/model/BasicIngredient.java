package app.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "indredients" )
@Inheritance(strategy = InheritanceType.JOINED)
@NamedQueries({
		@NamedQuery(
				name = "BasicIngredient.findByPriceSumsGreaterThanGivenPriceNJPQL", 
				query = "SELECT bi FROM BasicIngredient bi GROUP BY bi.name HAVING SUM(bi.price) > :price"),
		@NamedQuery(
				name = "BasicIngredient.deleteByNameNJPQL", 
				query = "DELETE FROM BasicIngredient AS bi WHERE bi.name = :name"),
		@NamedQuery(
				name = "BasicIngredient.increasePriceByGivenPercentNJPQL", 
				query = "UPDATE BasicIngredient AS bi SET bi.price = bi.price * (1 + (:percent / 100))"),
		@NamedQuery(
				name = "BasicIngredient.increasePriceByGivenPercentOfListedIngredientsNJPQL", 
				query = "UPDATE BasicIngredient AS bi SET bi.price = bi.price * (1 + (:percent / 100)) WHERE bi IN :ingredients")
})
public abstract class BasicIngredient implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic
    private String name;
    @Basic
    private BigDecimal price;

    @ManyToMany(mappedBy = "ingredients")
    private Set<BasicShampoo> shampoos;

    public BasicIngredient() {
    }

    public BasicIngredient(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Set<BasicShampoo> getShampoos() {
        return shampoos;
    }

    public void setShampoos(Set<BasicShampoo> shampoos) {
        this.shampoos = shampoos;
    }

    @Override
    public String toString() {
        return "BasicIngredient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BasicIngredient that = (BasicIngredient) o;

        return id.equals(that.id);
    }

}

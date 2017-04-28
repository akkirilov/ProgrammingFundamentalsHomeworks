package akkProject.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "addCategory")
public class AddCategory {
    private Integer id;
    private String addCategoryName;
    private Set<Add> adds;

    public AddCategory() {
        this.adds = new HashSet<>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "addCategoryName")
    public String getAddCategoryName() {
        return addCategoryName;
    }

    public void setAddCategoryName(String addCategoryName) {
        this.addCategoryName = addCategoryName;
    }

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "adds_categories")
    public Set<Add> getAdds() {
        return adds;
    }

    public void setAdds(Set<Add> adds) {
        this.adds = adds;
    }

    public void addAdd(Add add) {
        this.adds.add(add);
    }

    public void removeAdd(Add add) {
        this.adds.remove(add);
    }
}

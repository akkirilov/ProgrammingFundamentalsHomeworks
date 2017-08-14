package akkProject.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Adds")
public class Add {
    private Integer id;
    private String title;
    private String content;
    private LocalDate dateAdd;
    private User addUserId;
    private AddCategory addCategory;

    public Add() {
        this.dateAdd = LocalDate.now();
    }

    public Add(String title, String content, User addUserId) {
        this.title = title;
        this.content = content;
        this.addUserId = addUserId;

        this.dateAdd = LocalDate.now();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "title", nullable = false)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "content", columnDefinition = "text", nullable = false)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Column(name = "dateAdd", nullable = false)
    public LocalDate getDateAdd() {
        return dateAdd;
    }

    public void setDateAdd(LocalDate dateAdd) {
        this.dateAdd = dateAdd;
    }

    @ManyToOne()
    @JoinColumn(nullable = false, name = "addUserId")
    public User getAddUserId() {
        return addUserId;
    }

    public void setAddUserId(User addUserId) {
        this.addUserId = addUserId;
    }

    @ManyToOne()
    @JoinColumn(nullable = false, name = "categoryId")
    public AddCategory getAddCategory() {
        return addCategory;
    }

    public void setAddCategory(AddCategory addCategory) {
        this.addCategory = addCategory;
    }

    @Transient
    public String getSummary(){
        if(this.getContent().length() > 50){
            return this.getContent().substring(0, 49) + "...";
        }

        return this.getContent();
    }
}

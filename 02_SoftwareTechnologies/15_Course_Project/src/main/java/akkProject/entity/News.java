package akkProject.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "news")
public class News {
    private Integer id;
    private String title;
    private String content;
    private LocalDate date;
    private User newsUserId;
    private Set<Category> categories;

    public News(String title, String content) {
        this.title = title;
        this.content = content;

        this.date = LocalDate.now();
    }

    public News() {
        this.categories = new HashSet<>();
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

    @Column(name = "content", nullable = false)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Column(name = "date", nullable = false)
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @ManyToOne
    @JoinColumn(nullable = false, name = "newsUserId")
    public User getNewsUserId() {
        return newsUserId;
    }

    public void setNewsUserId(User newsUserId) {
        this.newsUserId = newsUserId;
    }

    @ManyToMany(mappedBy = "news")
    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }
}
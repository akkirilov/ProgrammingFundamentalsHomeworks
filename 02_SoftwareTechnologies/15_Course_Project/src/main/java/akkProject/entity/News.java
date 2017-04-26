package akkProject.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "News")
public class News {
    private Integer id;
    private String title;
    private String content;
    private LocalDate date;
    private User newsUserId;

    public News() {
        this.date = LocalDate.now();
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

    @ManyToOne()
    @JoinColumn(nullable = false, name = "newsUserId")
    public User getNewsUserId() {
        return newsUserId;
    }

    public void setNewsUserId(User newsUserId) {
        this.newsUserId = newsUserId;
    }
}
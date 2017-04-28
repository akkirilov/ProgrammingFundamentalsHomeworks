package akkProject.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Trainings")
public class Training {
    private Integer id;
    private User trainingUserId;
    private TrainingCategory trainingCategory;
    private String title;
    private String content;
    private String location;
    private LocalDate dateAdd;
    private LocalDate startDate;
    private LocalDate endDate;

    public Training() {
        this.dateAdd = LocalDate.now();
    }

    public Training(String title, String content, User trainingUserId) {
        this.title = title;
        this.content = content;
        this.trainingUserId = trainingUserId;

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

    @ManyToOne()
    @JoinColumn(nullable = false, name = "trainingUserId")
    public User getTrainingUserId() {
        return trainingUserId;
    }

    public void setTrainingUserId(User trainingUserId) {
        this.trainingUserId = trainingUserId;
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

    @Column(name = "location", nullable = false)
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Column(name = "dateAdd", nullable = false)
    public LocalDate getDateAdd() {
        return dateAdd;
    }

    public void setDateAdd(LocalDate dateAdd) {
        this.dateAdd = dateAdd;
    }

    @Column(name = "dateStart")
    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    @Column(name = "dateEnd")
    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @ManyToOne()
    @JoinColumn(nullable = false, name = "categoryId")
    public TrainingCategory getTrainingCategory() {
        return trainingCategory;
    }

    public void setTrainingCategory(TrainingCategory trainingCategory) {
        this.trainingCategory = trainingCategory;
    }

    @Transient
    public String getSummary(){
        if(this.getContent().length() > 50){
            return this.getContent().substring(0, 49) + "...";
        }

        return this.getContent();
    }
}

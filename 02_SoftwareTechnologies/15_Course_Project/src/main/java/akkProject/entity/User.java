package akkProject.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "Users")
public class User {
    private Integer id;
    private String name;
    private String type;
    private String email;
    private ContactDetails contactDetails;
    private Set<MainCategory> mainCategories;
    private Set<News> news;
    private Set<Role> roles;
    private Set<Training> trainings;
    private Set<Add> adds;
    private String summary;
    private String logoUrl;
    private String password;
    private LocalDate date;

    public User() {    }

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;

        this.date = LocalDate.now();
        this.mainCategories = new HashSet<>();
        this.news = new HashSet<>();
        this.roles = new HashSet<>();
        this.trainings = new HashSet<>();
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

    @Column(name = "name", unique = true, nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "type", nullable = false)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Column(name = "email", unique = true, nullable = false)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @OneToOne(fetch = FetchType.EAGER)
    @JoinTable(name = "user_contacts")
    public ContactDetails getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(ContactDetails contactDetails) {
        this.contactDetails = contactDetails;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_categories")
    public Set<MainCategory> getMainCategories() {
        return mainCategories;
    }

    public void setMainCategories(Set<MainCategory> mainCategories) {
        this.mainCategories = mainCategories;
    }

    public void addMainCategory(MainCategory mainCategory) {
        this.mainCategories.add(mainCategory);
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles")
    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public void addRole(Role role) {
        this.roles.add(role);
    }

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_news")
    public Set<News> getNews() {
        return news;
    }

    public void setNews(Set<News> news) {
        this.news = news;
    }

    public void addNews(News news) {
        this.news.add(news);
    }

    public void removeNews(News news) {
        this.news.remove(news);
    }

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_trainings")
    public Set<Training> getTrainings() {
        return trainings;
    }

    public void setTrainings(Set<Training> trainings) {
        this.trainings = trainings;
    }

    public void addTraining(Training training) {
        this.trainings.add(training);
    }

    public void removeTraining(Training training) {
        this.trainings.remove(training);
    }

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_adds")
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

    @Column(columnDefinition = "text", name = "summary")
    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Column(name = "logoUrl")
    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    @Column(name = "password", nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "date", nullable = false)
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public boolean isSelectType(String property){
       return this.type.equals(property);
    }

    @Transient
    public Boolean isAdmin(){
        return this.getRoles().stream().anyMatch(r -> r.getRoleName().equals("ROLE_ADMIN"));
    }

    @Transient
    public Boolean isNewsAuthor(News news){
        return Objects.equals(this.getId(), news.getNewsUserId().getId());
    }

    @Transient
    public Boolean isTrainingAuthor(Training training){
        return Objects.equals(this.getId(), training.getTrainingUserId().getId());
    }

    @Transient
    public Boolean isAddAuthor(Add add){
        return Objects.equals(this.getId(), add.getAddUserId().getId());
    }

    @Transient
    public boolean isEmptyOrNullProperty(String property) {
        if (property == null || property.equals("")) {
            return false;
        }

        return true;
    }
}
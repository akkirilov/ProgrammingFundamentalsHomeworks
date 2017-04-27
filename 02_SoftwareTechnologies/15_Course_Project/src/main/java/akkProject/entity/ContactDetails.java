package akkProject.entity;

import javax.persistence.*;

@Entity
@Table(name = "ContactDetails")
public class ContactDetails {
    private Integer id;
    private User detailsUserId;
    private String phone;
    private String fax;
    private String web;
    private String country;
    private String city;
    private String address;

    public ContactDetails() {    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @OneToOne
    @JoinColumn(nullable = false, name = "contactDetailsUserId")
    public User getDetailsUserId() {
        return detailsUserId;
    }

    public void setDetailsUserId(User detailsUserId) {
        this.detailsUserId = detailsUserId;
    }

    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Column(name = "fax")
    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    @Column(name = "web")
    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    @Column(name = "country")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Column(name = "city")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}

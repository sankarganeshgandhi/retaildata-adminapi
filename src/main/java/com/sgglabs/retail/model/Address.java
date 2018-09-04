package com.sgglabs.retail.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

/**
 * CREATE TABLE Address(
 *     Id INT(10) NOT NULL AUTO_INCREMENT,
 *     Line1 VARCHAR(200) NOT NULL,
 *     Line2 VARCHAR(200) NOT NULL,
 *     City VARCHAR(50) NOT NULL,
 *     Country VARCHAR(50) NOT NULL,
 *     Postcode VARCHAR(50) NOT NULL,
 *     AddressTypeId INT(2) NOT NULL,
 *     StatusId INT(2) NOT NULL,
 *     UserTId INT(10) NOT NULL,
 *     CreatedDate DATE,
 *     ModifiedDate DATE,
 *     PRIMARY KEY (Id),
 *     FOREIGN KEY (AddressTypeId) REFERENCES AddressType(Id),
 *     FOREIGN KEY (UserTId) REFERENCES UserT(Id),
 *     FOREIGN KEY (StatusId) REFERENCES Status(Id)
 * );
 */

@Entity(name = "Address")
@Table(name = "Address")
public class Address {
    private static final Logger LOG = LoggerFactory.getLogger(Address.class);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Line1")
    private String addressLine1;

    @Column(name = "Line2")
    private String addressLine2;

    @Column(name = "City")
    private String city;

    @Column(name = "Country")
    private String country;

    @Column(name = "Postcode")
    private String postCode;

    @Column(name = "AddressTypeId")
    private String addressTypeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UserTId")
    @JsonBackReference
    private User user;

    @Column(name = "StatusId")
    private Integer statusId;

    @Column(name = "CreatedDate")
    private LocalDate createdDate;

    @Column(name = "ModifiedDate")
    private LocalDate modifiedDate;

    public Address() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getAddressTypeId() {
        return addressTypeId;
    }

    public void setAddressTypeId(String addressTypeId) {
        this.addressTypeId = addressTypeId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDate getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(LocalDate modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(id, address.id) &&
                Objects.equals(addressLine1, address.addressLine1) &&
                Objects.equals(addressLine2, address.addressLine2) &&
                Objects.equals(city, address.city) &&
                Objects.equals(country, address.country) &&
                Objects.equals(postCode, address.postCode) &&
                Objects.equals(addressTypeId, address.addressTypeId) &&
                Objects.equals(user.getId(), address.user.getId()) &&
                Objects.equals(statusId, address.statusId) &&
                Objects.equals(createdDate, address.createdDate) &&
                Objects.equals(modifiedDate, address.modifiedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, addressLine1, addressLine2, city, country, postCode, addressTypeId,
                user.getId(), statusId, createdDate, modifiedDate);
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", addressLine1='" + addressLine1 + '\'' +
                ", addressLine2='" + addressLine2 + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", postCode='" + postCode + '\'' +
                ", addressTypeId='" + addressTypeId + '\'' +
                ", user='" + user.getUserName() + '\'' +
                ", statusId='" + statusId + '\'' +
                ", createdDate=" + createdDate +
                ", modifiedDate=" + modifiedDate +
                '}';
    }
}
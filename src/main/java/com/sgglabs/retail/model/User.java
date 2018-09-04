package com.sgglabs.retail.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

/**
 * CREATE TABLE UserT(
 * Id INT(10) NOT NULL AUTO_INCREMENT,
 * Username VARCHAR(30) NOT NULL,
 * Password VARCHAR(30) NOT NULL,
 * FirstName VARCHAR(50) NOT NULL,
 * LastName VARCHAR(50) NOT NULL,
 * EmailAddress VARCHAR(150) NOT NULL,
 * PhoneNumber VARCHAR(15) NOT NULL,
 * StatusId INT(2) NOT NULL,
 * CreatedDate DATE,
 * ModifiedDate DATE,
 * PRIMARY KEY (Id),
 * FOREIGN KEY (StatusId) REFERENCES Status(Id)
 * );
 */
@Entity
@Table(name = "UserT")
public class User {
    private static final Logger LOG = LoggerFactory.getLogger(User.class);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Username")
    private String userName;

    @Column(name = "FirstName")
    private String firstName;

    @Column(name = "LastName")
    private String lastName;

    @Column(name = "EmailAddress")
    private String emailAddress;

    @Column(name = "PhoneNumber")
    private String phoneNumber;

    @Column(name = "StatusId")
    private String statusId;

    @Column(name = "CreatedDate")
    private LocalDate createdDate;

    @Column(name = "ModifiedDate")
    private LocalDate modifiedDate;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getStatusId() {
        return statusId;
    }

    public void setStatusId(String statusId) {
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
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(userName, user.userName) &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(emailAddress, user.emailAddress) &&
                Objects.equals(phoneNumber, user.phoneNumber) &&
                Objects.equals(statusId, user.statusId) &&
                Objects.equals(createdDate, user.createdDate) &&
                Objects.equals(modifiedDate, user.modifiedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, firstName, lastName, emailAddress, phoneNumber, statusId,
                createdDate, modifiedDate);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", statusId='" + statusId + '\'' +
                ", createdDate=" + createdDate +
                ", modifiedDate=" + modifiedDate +
                '}';
    }
}
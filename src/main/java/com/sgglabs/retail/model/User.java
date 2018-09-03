package com.sgglabs.retail.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * CREATE TABLE UserT(
 *     Id INT(10) NOT NULL AUTO_INCREMENT,
 *     Username VARCHAR(30) NOT NULL,
 *     Password VARCHAR(30) NOT NULL,
 *     FirstName VARCHAR(50) NOT NULL,
 *     LastName VARCHAR(50) NOT NULL,
 *     EmailAddress VARCHAR(150) NOT NULL,
 *     PhoneNumber VARCHAR(15) NOT NULL,
 *     StatusId INT(2) NOT NULL,
 *     CreatedDate DATE,
 *     ModifiedDate DATE,
 *     PRIMARY KEY (Id),
 *     FOREIGN KEY (StatusId) REFERENCES Status(Id)
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
}
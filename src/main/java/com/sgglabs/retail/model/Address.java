package com.sgglabs.retail.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.time.LocalDate;

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

@Entity
@Table(name = "Address")
public class Address {
    private static final Logger LOG = LoggerFactory.getLogger(Address.class);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    @Column(name = "StatusId")
    private String statusId;

    @Column(name = "CreatedDate")
    private LocalDate createdDate;

    @Column(name = "ModifiedDate")
    private LocalDate modifiedDate;
}
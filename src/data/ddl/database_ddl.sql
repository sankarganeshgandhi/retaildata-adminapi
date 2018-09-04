DROP TABLE Address;
DROP TABLE AddressType;
DROP TABLE UserT;
DROP TABLE Status;

CREATE TABLE Status(
    Id INT(2) NOT NULL AUTO_INCREMENT,
    Description VARCHAR(30) NOT NULL,
    CreatedDate DATE,
    ModifiedDate DATE,
    PRIMARY KEY (Id)
) ENGINE = INNODB;

CREATE TABLE UserT(
    Id INT(10) NOT NULL AUTO_INCREMENT,
    Username VARCHAR(30) NOT NULL,
    Password VARCHAR(30) NOT NULL,
    FirstName VARCHAR(50) NOT NULL,
    LastName VARCHAR(50) NOT NULL,
    EmailAddress VARCHAR(150) NOT NULL,
    PhoneNumber VARCHAR(15) NOT NULL,
    StatusId INT(2) NOT NULL,
    CreatedDate DATE,
    ModifiedDate DATE,
    PRIMARY KEY (Id),
    FOREIGN KEY (StatusId) REFERENCES Status(Id)
) ENGINE = INNODB;

#####
## Residence, Business, Communication
#####
CREATE TABLE AddressType(
    Id INT(2) NOT NULL AUTO_INCREMENT,
    Description VARCHAR(30) NOT NULL,
    StatusId INT(2) NOT NULL,
    CreatedDate DATE,
    ModifiedDate DATE,
    PRIMARY KEY (Id),
    FOREIGN KEY (StatusId) REFERENCES Status(Id)
) ENGINE = INNODB;

CREATE TABLE Address(
    Id INT(10) NOT NULL AUTO_INCREMENT,
    Line1 VARCHAR(200) NOT NULL,
    Line2 VARCHAR(200) NOT NULL,
    City VARCHAR(50) NOT NULL,
    Country VARCHAR(50) NOT NULL,
    Postcode VARCHAR(50) NOT NULL,
    AddressTypeId INT(2) NOT NULL,
    StatusId INT(2) NOT NULL,
    UserTId INT(10) NOT NULL,
    CreatedDate DATE,
    ModifiedDate DATE,
    PRIMARY KEY (Id),
    FOREIGN KEY (AddressTypeId) REFERENCES AddressType(Id),
    FOREIGN KEY (UserTId) REFERENCES UserT(Id),
    FOREIGN KEY (StatusId) REFERENCES Status(Id)
) ENGINE = INNODB;

INSERT INTO Status (Description, CreatedDate, ModifiedDate) VALUES ("Inactive", Now(), Now());
INSERT INTO Status (Description, CreatedDate, ModifiedDate) VALUES ("Active", Now(), Now());
INSERT INTO AddressType(Description, StatusId, CreatedDate, ModifiedDate)
    VALUES ("Personal", 2, Now(), Now());
INSERT INTO AddressType(Description, StatusId, CreatedDate, ModifiedDate)
    VALUES ("Communication", 2, Now(), Now());

INSERT INTO UserT(Username, Password, FirstName, LastName, EmailAddress, PhoneNumber, StatusId, CreatedDate,
    ModifiedDate)
    VALUES ("sankarg", "welcome123!", "Sankarganesh", "Gandhi", "sankarganesh.gandhi@gmail.com",
    "07946318867", 2, Now(), Now());

INSERT INTO Address(Line1, Line2, City, Country, Postcode, AddressTypeId, UserTId, StatusId, CreatedDate,
    ModifiedDate)
    VALUES ("Address Line1", "Address Line2", "Manchester", "UK", "M210BH",
    1, 1, 2, Now(), Now());

DROP TABLE AuthSession;

CREATE TABLE AuthSession (
    Id BIGINT(10) NOT NULL AUTO_INCREMENT,
    UserId INT(10) NOT NULL,
    Username VARCHAR(30) NOT NULL,
    SessionId VARCHAR(250) NOT NULL,
    LoginTime DATE NOT NULL,
    LogoutTime DATE,
    StatusId INT(2) NOT NULL,
    CreatedDate DATE,
    ModifiedDate DATE,
    PRIMARY KEY (Id),
    FOREIGN KEY (StatusId) REFERENCES Status(Id)
) ENGINE = INNODB;
CREATE  TABLE `test`.`CUSTOMER` (
  `CUSTOMERID` INT NOT NULL AUTO_INCREMENT ,
  `CUSTOMERNAME` VARCHAR(200) NULL ,
  `MEMBERSINCE` DATETIME NULL ,
  `balance` FLOAT NULL ,
  PRIMARY KEY (`customerId`) );


CREATE  TABLE `test`.`ADDRESS` (
  `ADDRESSID` BIGINT NOT NULL AUTO_INCREMENT ,
  `HOUSENUMBER` INT NULL ,
  `STREET` VARCHAR(200) NULL ,
  `CITY` VARCHAR(200) NULL ,
  `STATE` VARCHAR(200) NULL ,
  `COUNTRY` VARCHAR(200) NULL ,
  `CUSTOMERID` INT NOT NULL,
  PRIMARY KEY (`addressId`) );


CREATE  TABLE `test`.`CONTACT` (
  `CONTACTID` BIGINT NOT NULL AUTO_INCREMENT ,
  `PHONENUMBER` VARCHAR(200) NULL ,
  `PHONETYPE` VARCHAR(200) NULL ,
  `CONTACTTYPE` VARCHAR(200) NULL ,
  `EMAILID` VARCHAR(200) NULL ,
  PRIMARY KEY (`CONTACTID`) );


CREATE  TABLE `test`.`CREDITCARD` (
  `CREDITCARDID` BIGINT NOT NULL AUTO_INCREMENT ,
  `CARDNUMBER` VARCHAR(200) NULL ,
  `SECURITYCODE` VARCHAR(200) NULL ,
  `EXPDATE` DATETIME NULL ,
  `CARDTYPE` VARCHAR(200) NULL ,
  PRIMARY KEY (`CREDITCARDID`) );
 
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
  
  
 CREATE TABLE `PRODUCT` (
  `PRODUCTID` int(11) NOT NULL AUTO_INCREMENT,
  `PROD_SHORT_NAME` varchar(45) DEFAULT NULL,
  `PRODUCTNAME` varchar(100) DEFAULT NULL,
  `PRODUCT_PRICE` float DEFAULT NULL,
  `PRODUCT_IMAGE_PATH` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`PRODUCTID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1$$

delimiter $$

CREATE TABLE `VENDORS` (
  `vendorId` int(11) NOT NULL AUTO_INCREMENT,
  `VENDOR_SHORT_NAME` varchar(45) DEFAULT NULL,
  `VENDOR_NAME` varchar(100) DEFAULT NULL,
  `REGISTRATION_DATE` datetime DEFAULT NULL,
  `VENDOR_STATUS` varchar(45) DEFAULT NULL,
  `PAYABLE_AMT` float DEFAULT NULL,
  `ADDRESSID` int(11) DEFAULT NULL,
  `CONTACTID` int(11) DEFAULT NULL,
  PRIMARY KEY (`vendorId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1$$



 
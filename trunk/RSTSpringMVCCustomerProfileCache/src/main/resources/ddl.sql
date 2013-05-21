CREATE TABLE `Customer` (
  `CUSTOMERID` int(11) NOT NULL AUTO_INCREMENT,
  `CUSTOMERNAME` varchar(200) DEFAULT NULL,
  `MEMBERSINCE` datetime DEFAULT NULL,
  `BALANCE` float DEFAULT NULL,
  PRIMARY KEY (`CUSTOMERID`)
);

CREATE TABLE `ADDRESS` (
  `ADDRESSID` bigint(20) NOT NULL AUTO_INCREMENT,
  `HOUSENUMBER` int(11) DEFAULT NULL,
  `STREET` varchar(200) DEFAULT NULL,
  `CITY` varchar(200) DEFAULT NULL,
  `STATE` varchar(200) DEFAULT NULL,
  `COUNTRY` varchar(200) DEFAULT NULL,
  `OWNERTYPEID` int(11) DEFAULT NULL,
  `ADDRESSTYPEID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ADDRESSID`)
);

CREATE TABLE `Customer` (
  `CUSTOMERID` int(11) NOT NULL AUTO_INCREMENT,
  `CUSTOMERNAME` varchar(200) DEFAULT NULL,
  `MEMBERSINCE` datetime DEFAULT NULL,
  `BALANCE` float DEFAULT NULL,
  PRIMARY KEY (`CUSTOMERID`)
);

CREATE TABLE `CREDITCARD` (
  `CREDITCARDID` bigint(20) NOT NULL AUTO_INCREMENT,
  `CARDNUMBER` varchar(200) DEFAULT NULL,
  `SECURITYCODE` varchar(200) DEFAULT NULL,
  `EXPDATE` datetime DEFAULT NULL,
  `CARDTYPE` varchar(200) DEFAULT NULL,
  `CUSTOMERID` int(11) NOT NULL,
  PRIMARY KEY (`CREDITCARDID`)
);

CREATE  TABLE `test`.`OwnerTypes` (
  `OWNERTYPEID` INT NOT NULL ,
  `OWNERTYPENAME` VARCHAR(45) NULL ,
  PRIMARY KEY (`OwnerTypeId`) );

CREATE  TABLE `test`.`AddressTypes` (
  `ADDRESSTYPEID` INT NOT NULL ,
  `ADDRESSTYPENAME` VARCHAR(45) NULL ,
  PRIMARY KEY (`AddressTypeId`) );


INSERT INTO `AddressTypes` (`AddressTypeId`,`AddressTypeName`) VALUES (1,'Shipping');
INSERT INTO `AddressTypes` (`AddressTypeId`,`AddressTypeName`) VALUES (2,'Mailing');
INSERT INTO `AddressTypes` (`AddressTypeId`,`AddressTypeName`) VALUES (3,'Billing');

INSERT INTO `test`.`OwnerTypes` (`OwnerTypeId`, `OwnerTypeName`) VALUES ('1', 'Customer');
INSERT INTO `test`.`OwnerTypes` (`OwnerTypeId`, `OwnerTypeName`) VALUES ('2', 'Vendor');

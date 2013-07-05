DROP TABLE `RECIPE`;
CREATE TABLE `RECIPE` (
  `RECIPEID` int(11) NOT NULL AUTO_INCREMENT,
  `RECIPE_NAME` varchar(200) DEFAULT NULL,
  `DESCRIPTION` varchar(2000) DEFAULT NULL,
  `CREATED_ON` datetime DEFAULT NULL,
  `CREATED_BY` varchar(200) DEFAULT NULL,
  `RECIPETYPE` varchar(200) DEFAULT NULL,
  `VISITOR_COUNT` int(11) DEFAULT NULL,
  `PROCESS` BLOB DEFAULT NULL,
  PRIMARY KEY (`RECIPEID`)
);

DROP TABLE `RECIPE_INGREDIENTS`;
CREATE TABLE `RECIPE_INGREDIENTS` (
  `INGREDIENT_ID` int(11) NOT NULL AUTO_INCREMENT,
  `INGREDIENT_NAME` varchar(200) DEFAULT NULL,
  `UOM` varchar(200) DEFAULT NULL,
  `QUANTITY` varchar(200) DEFAULT NULL,
  `RECIPEID` int(11) DEFAULT NULL,
  PRIMARY KEY (`INGREDIENT_ID`)
);

INSERT INTO `test`.`RECIPE` (`RECIPE_NAME`, `DESCRIPTION`, `CREATED_ON`, `CREATED_BY`, `RECIPETYPE`, `VISITOR_COUNT`) 
VALUES ('Test1', 'T', CURDATE(), 'Admin', 'Chicken', '1');
INSERT INTO `test`.`RECIPE` (`RECIPE_NAME`, `DESCRIPTION`, `CREATED_ON`, `CREATED_BY`, `RECIPETYPE`, `VISITOR_COUNT`) 
VALUES ('Test2', 'T', CURDATE(), 'Admin', 'Mutton', '1');
INSERT INTO `test`.`RECIPE` (`RECIPE_NAME`, `DESCRIPTION`, `CREATED_ON`, `CREATED_BY`, `RECIPETYPE`, `VISITOR_COUNT`) 
VALUES ('Test3', 'T', CURDATE(), 'Admin', 'Veggie', '1');

INSERT INTO `test`.`RECIPE_INGREDIENTS` (`INGREDIENT_NAME`, `UOM`, `QUANTITY`, `RECIPEID`) VALUES ('Salt', 'bla bla', '100gm', '1');
INSERT INTO `test`.`RECIPE_INGREDIENTS` (`INGREDIENT_NAME`, `QUANTITY`, `RECIPEID`) VALUES ('Sugar', '200gm', '1');
INSERT INTO `test`.`RECIPE_INGREDIENTS` (`INGREDIENT_NAME`, `QUANTITY`, `RECIPEID`) VALUES ('Chicken', '1kg', '1');
INSERT INTO `test`.`RECIPE_INGREDIENTS` (`INGREDIENT_NAME`, `QUANTITY`, `RECIPEID`) VALUES ('Mutton', '1kg', '2');
INSERT INTO `test`.`RECIPE_INGREDIENTS` (`INGREDIENT_NAME`, `QUANTITY`) VALUES ('Veg', '300gm', '3');

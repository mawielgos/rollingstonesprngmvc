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

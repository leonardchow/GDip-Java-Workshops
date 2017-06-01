CREATE SCHEMA `scratchDB`;
CREATE TABLE `scratchDB`.`Students` (
  `id` VARCHAR(12) NOT NULL,
  `firstName` VARCHAR(45) NULL,
  `lastName` VARCHAR(45) NULL,
  `feeTotal` DECIMAL(10,2) NULL,
  `feePaid` DECIMAL(10,2) NULL,
  PRIMARY KEY (`id`));

INSERT INTO `scratchDB`.`Students` (`id`, `firstName`, `lastName`, `feeTotal`, `feePaid`) VALUES ('A0160001E', 'James', 'Tan', '1200', '0');
INSERT INTO `scratchDB`.`Students` (`id`, `firstName`, `lastName`, `feeTotal`, `feePaid`) VALUES ('A0160002F', 'Patrick', 'Lim', '1200', '10');
INSERT INTO `scratchDB`.`Students` (`id`, `firstName`, `lastName`, `feeTotal`, `feePaid`) VALUES ('A0160003K', 'Frederick', 'Keong', '1200', '1000');
INSERT INTO `scratchDB`.`Students` (`id`, `firstName`, `lastName`, `feeTotal`, `feePaid`) VALUES ('A0160004Y', 'Simon', 'Sim', '1200', '0');

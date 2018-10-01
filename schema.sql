DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(64) NOT NULL,
  `enabled`  tinyint(1) NOT NULL DEFAULT 1,
  `created_by` varchar(50) DEFAULT NULL,
  `created_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `last_modified_by` varchar(50) DEFAULT NULL,
  `last_modified_date` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  CONSTRAINT UC_user UNIQUE (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `user_authority`;
CREATE TABLE `user_authority` (
	`user_id` int(11) unsigned NOT NULL,
    `authority` varchar(50) NOT NULL,
    PRIMARY KEY (`user_id`, `authority`),
    CONSTRAINT `FK_user_authority` FOREIGN KEY (`user_id`) REFERENCES user(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO user (username, password, created_by, last_modified_by, last_modified_date) 
VALUES ('admin', '$2a$10$CCR5CnxqJ8Z1Zxx7n62pmOEIQh5inRm/jhXhC8VucWXMiIykY5wni', 'admin', 'admin', CURRENT_TIMESTAMP);
INSERT INTO user_authority VALUES (1, 'ROLE_ADMIN');

INSERT INTO user (username, password, created_by, last_modified_by, last_modified_date) 
VALUES ('john', '$2a$10$9mue0wE9g/5F6XroxRSP7.H3N2UGy87Jei4Kej2wQ9pqLfT0oihfG', 'admin', 'admin', CURRENT_TIMESTAMP);
INSERT INTO user_authority VALUES (1, 'ROLE_USER');
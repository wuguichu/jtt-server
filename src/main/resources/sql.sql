CREATE DATABASE IF NOT EXISTS `jtt`;

CREATE TABLE IF NOT EXISTS `device_type`(
	`id` TINYINT UNSIGNED NOT NULL AUTO_INCREMENT,
	`type_name` CHAR(20) NOT NULL UNIQUE,
	
	PRIMARY KEY(`id`)
)COMMENT '设备类型';

CREATE TABLE IF NOT EXISTS `device_info`(
	`device_serial` CHAR(6),
	`car_type` CHAR(12),
	`device_type` TINYINT UNSIGNED NOT NULL,
	`app_version` VARCHAR(32),
	`mcu_version` VARCHAR(32),
	`ai_version` VARCHAR(32),
	
	FOREIGN KEY(`device_type`) REFERENCES device_type(`id`),
	PRIMARY KEY(`device_serial`)
)COMMENT '设备信息';

CREATE TABLE IF NOT EXISTS `device_status`(
	`device_serial` CHAR(6) NOT NULL,
	`device_time` DATETIME NOT NULL,
	`gps_status` TINYINT,
	`sd1_status` TINYINT,
	`sd1_total_capacity` INT UNSIGNED,
	`sd1_serial_number` CHAR(20),
	`sd2_status` TINYINT,
	`sd2_total_capacity` INT UNSIGNED,
	`sd2_serial_number` CHAR(20),
	`sd3_status` TINYINT,
	`sd3_total_capacity` INT UNSIGNED,
	`sd3_serial_number` CHAR(20),
	`sd4_status` TINYINT,
	`sd4_total_capacity` INT UNSIGNED,
	`sd4_serial_number` CHAR(20),
	`udisk_status` TINYINT,
	`ummc_status` TINYINT,
	`channel_status` LONG,
	`record_status` LONG,
	`wireless_type` TINYINT UNSIGNED,
	`wireless_signal` TINYINT,
	`wireless_mode` TINYINT UNSIGNED,
	`wireless_mac` CHAR(20),
	`wireless_ip` CHAR(20),
	`wifi_sign` TINYINT,
	`wifi_singel` SMALLINT UNSIGNED,
	`wifi_features` TINYINT,
	`wifi_mode` TINYINT,
	
	PRIMARY KEY(`device_serial`, `device_time`)
)COMMENT '设备状态';
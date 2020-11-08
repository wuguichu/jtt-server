show databases;

use jtt;

show tables;

drop table if exists `device_type`;
create table if not exists `device_type`
(
    `id`        tinyint     not null auto_increment comment '设备类型id',
    `type_name` varchar(20) not null unique comment '设备类型名称',
    primary key (`id`)
) engine = InnoDB
  default charset 'UTF8MB4' comment '设备类型表';

drop table if exists `device_info`;
create table if not exists `device_info`
(
    `terminal_serial_number` char(6) not null comment '终端序列号',
    `car_number`             char(12) comment '车牌号',
    `device_type`            tinyint not null comment '设备型号',
    `app_version`            varchar(20) comment 'app版本号',
    `mcu_version`            varchar(20) comment 'mcu版本号',
    `ai_version`             varchar(20) comment 'ai版本号',
    primary key (`terminal_serial_number`),
    foreign key (`device_type`) references `device_type` (`id`)
) engine InnoDB
  default charset 'UTF8MB4' comment '设备信息';

drop table if exists `device_status`;
create table if not exists `device_status`
(
    `terminal_serial_number` char(6)      not null comment '终端序列号',
    `power_on_status`        bit          not null default false comment '是否是开机状态',
    `time`                   int unsigned not null comment '产生时间',
    `time_zone`              tinyint unsigned comment '时区',
    `system_status`          int unsigned comment '系统状态',
    `io_channel_status`      mediumint unsigned comment 'IO通道位图',
    `speed`                  mediumint unsigned comment '速度',
    `high`                   mediumint comment '高度',
    `direction_angle`        mediumint unsigned comment '方向角',
    `longitude`              double comment '纬度',
    `latitude`               double comment '经度',
    `gps_status`             tinyint unsigned comment 'GPS状态',
    `memory_type`            varchar(4) comment '存储器类型数组',
    `memory_status`          varchar(4) comment '存储器状态数组',
    `total_capacity`         varchar(16) comment '存储器总容量数组',
    `memory_serial_number`   varchar(60) comment '存储器序列号数组',
    `udisk_status`           tinyint unsigned comment 'UDISK状态',
    `ummc_status`            tinyint unsigned comment 'UMMC状态',
    `channel_status`         varchar(16) comment '通道状态数组',
    `record_status`          varchar(16) comment '录像状态数组',
    `net_type`               tinyint unsigned comment '网络类型',
    `signal`                 tinyint comment '信号值',
    `dial_mode`              tinyint unsigned comment '拨号模式',
    `mac`                    varchar(20) comment 'mac地址',
    `ip`                     char(20) comment 'ip地址',
    `module`                 tinyint unsigned comment '模块标识',
    `wifi_signal`            mediumint comment 'wifi信号值',
    `features`               tinyint unsigned comment 'wifi功能',
    `wifi_mode`              tinyint unsigned comment 'wifi模式',
    `peripheral_type`        varchar(32) comment '外设类型数组',
    `connection_status`      varchar(16) comment '外设连接状态数组',
    `peripheral_name`        varchar(320) comment '外设名称数组',
    `gsensor_status`         tinyint unsigned comment 'Gsensor状态',
    `terminal_voltage`       mediumint unsigned comment '终端电压',
    `acc_status`             tinyint unsigned comment 'ACC状态',
    `dms_authorization`      tinyint unsigned comment 'DMS授权状态',
    `adas_authorization`     tinyint unsigned comment 'adas授权状态',
    `bsd_authorization`      tinyint unsigned comment 'bsd授权状态',
    `internal_temperature`   mediumint comment '机内温度',
    `outside_temperature`    mediumint comment '机外温度',
    primary key (`terminal_serial_number`, `time`)
) engine InnoDB
  default charset 'UTF8MB4' comment '设备状态';

select car_number, id, type_name, app_version, mcu_version, ai_version
from jtt.device_info,
     jtt.device_type
where jtt.device_type.id = jtt.device_info.device_type
limit 0,20;

select @@session.sql_mode;
select @@global.sql_mode;
set @@global.sql_mode =
        'ONLY_FULL_GROUP_BY,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
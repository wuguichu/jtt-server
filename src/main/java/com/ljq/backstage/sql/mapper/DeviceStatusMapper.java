package com.ljq.backstage.sql.mapper;

import com.ljq.backstage.sql.entity.DeviceStatus;

public interface DeviceStatusMapper {
    int insert(DeviceStatus deviceStatus);

    int update(DeviceStatus deviceStatus);
}

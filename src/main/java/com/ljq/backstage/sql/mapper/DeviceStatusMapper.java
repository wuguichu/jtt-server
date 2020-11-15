package com.ljq.backstage.sql.mapper;

import com.ljq.backstage.sql.entity.DeviceStatus;
import org.apache.ibatis.annotations.Param;

public interface DeviceStatusMapper {
    int insert(DeviceStatus deviceStatus);

    int update(DeviceStatus deviceStatus);

    DeviceStatus getByTerminalSerialNumberAndTime(@Param("terminalSerialNumber") String terminalSerialNumber, @Param("time") Long time);
}

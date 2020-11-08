package com.ljq.backstage.sql.mapper;

import com.ljq.backstage.sql.entity.DeviceInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeviceInfoMapper {
    int insert(DeviceInfo deviceInfo);

    int deleteByTerminalSerialNumber(String terminalSerialNumber);

    int update(DeviceInfo deviceInfo);

    DeviceInfo getByTerminalSerialNumber(String terminalSerialNumber);

    List<DeviceInfo> getByPage(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize);
}
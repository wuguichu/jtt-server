package com.ljq.backstage.sql.mapper;

import com.ljq.backstage.sql.entity.DeviceType;

import java.util.List;

public interface DeviceTypeMapper {
    int insert(DeviceType deviceType);

    int delete(DeviceType deviceType);

    DeviceType getByTypeName(String typeName);

    List<DeviceType> get();
}

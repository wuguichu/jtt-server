package com.ljq.backstage.sql.mapper;

import com.ljq.backstage.sql.entity.DeviceStatus;
import org.mybatis.spring.support.SqlSessionDaoSupport;

public class DeviceStatusMapperImpl extends SqlSessionDaoSupport implements DeviceStatusMapper {

    @Override
    public int insert(DeviceStatus deviceStatus) {
        return getSqlSession().getMapper(DeviceStatusMapper.class).insert(deviceStatus);
    }

    @Override
    public int update(DeviceStatus deviceStatus) {
        return getSqlSession().getMapper(DeviceStatusMapper.class).update(deviceStatus);
    }

    @Override
    public DeviceStatus getByTerminalSerialNumberAndTime(String terminalSerialNumber, Long time) {
        return getSqlSession().getMapper(DeviceStatusMapper.class).getByTerminalSerialNumberAndTime(terminalSerialNumber, time);
    }
}

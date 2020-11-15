package com.ljq.backstage.sql.mapper;

import com.ljq.backstage.sql.entity.DeviceInfo;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

public class DeviceInfoMapperImpl extends SqlSessionDaoSupport implements DeviceInfoMapper {

    @Override
    public int insert(DeviceInfo deviceInfo) {
        return getSqlSession().getMapper(DeviceInfoMapper.class).insert(deviceInfo);
    }

    @Override
    public int deleteByTerminalSerialNumber(String terminalSerialNumber) {
        return getSqlSession().getMapper(DeviceInfoMapper.class).deleteByTerminalSerialNumber(terminalSerialNumber);
    }

    @Override
    public int update(DeviceInfo deviceInfo) {
        return getSqlSession().getMapper(DeviceInfoMapper.class).update(deviceInfo);
    }

    @Override
    public DeviceInfo getByTerminalSerialNumber(String terminalSerialNumber) {
        return getSqlSession().getMapper(DeviceInfoMapper.class).getByTerminalSerialNumber(terminalSerialNumber);
    }

    @Override
    public List<DeviceInfo> getByPage(int pageNum, int pageSize) {
        return getSqlSession().getMapper(DeviceInfoMapper.class).getByPage(pageNum, pageSize);
    }
}

package com.ljq.backstage.sql.mapper;

import com.ljq.backstage.sql.entity.DeviceType;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

public class DeviceTypeMapperImpl extends SqlSessionDaoSupport implements DeviceTypeMapper {
    @Override
    public int insert(DeviceType deviceType) {
        return getSqlSession().getMapper(DeviceTypeMapper.class).insert(deviceType);
    }

    @Override
    public int delete(DeviceType deviceType) {
        return getSqlSession().getMapper(DeviceTypeMapper.class).delete(deviceType);
    }

    @Override
    public DeviceType getByTypeName(String typeName) {
        return getSqlSession().getMapper(DeviceTypeMapper.class).getByTypeName(typeName);
    }

    @Override
    public List<DeviceType> get() {
        return getSqlSession().getMapper(DeviceTypeMapper.class).get();
    }
}

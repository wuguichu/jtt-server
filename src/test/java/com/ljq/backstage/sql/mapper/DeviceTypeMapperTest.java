package com.ljq.backstage.sql.mapper;

import com.ljq.backstage.sql.entity.DeviceType;
import com.ljq.backstage.sql.utils.SqlUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class DeviceTypeMapperTest {

    @Test
    public void insert() {
        SqlSession sqlSession = SqlUtils.getSqlSession();
        DeviceTypeMapper mapper = sqlSession.getMapper(DeviceTypeMapper.class);
        int insertCount = mapper.insert(new DeviceType((byte) 1, "BK6I"));
//        int insertCount = mapper.insert(new DeviceType((byte) 1, "C720X"));
//        int insertCount = mapper.insert(new DeviceType((byte) 1, "SP5I"));

        System.out.println(insertCount);

        if (insertCount <= 0) {
            System.out.println("回滚");
            sqlSession.rollback();
        } else {
            sqlSession.commit();
        }
        sqlSession.close();
    }

    @Test
    public void delete() {
        SqlSession sqlSession = SqlUtils.getSqlSession();
        DeviceTypeMapper mapper = sqlSession.getMapper(DeviceTypeMapper.class);
        int insertCount = mapper.delete(new DeviceType((byte) 1, "C720X"));
//        int insertCount = mapper.delete(new DeviceType((byte) 1, "SP5I"));
//
        System.out.println(insertCount);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void getByTypeName() {
        SqlSession sqlSession = SqlUtils.getSqlSession();
        DeviceTypeMapper mapper = sqlSession.getMapper(DeviceTypeMapper.class);

        DeviceType deviceType = mapper.getByTypeName("SP5I");
        System.out.println(deviceType);

        sqlSession.close();
    }

    @Test
    public void get() {
        SqlSession sqlSession = SqlUtils.getSqlSession();
        DeviceTypeMapper mapper = sqlSession.getMapper(DeviceTypeMapper.class);

        List<DeviceType> deviceTypeList = mapper.get();
        deviceTypeList.forEach(System.out::println);

        sqlSession.close();
    }
}
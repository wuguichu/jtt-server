package com.ljq.backstage.sql.mapper;

import com.ljq.backstage.sql.entity.DeviceInfo;
import com.ljq.backstage.sql.entity.DeviceType;
import com.ljq.backstage.sql.utils.SqlUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class DeviceInfoMapperTest {

    @Test
    public void insert() {
        SqlSession sqlSession = SqlUtils.getSqlSession();
        DeviceInfoMapper mapper = sqlSession.getMapper(DeviceInfoMapper.class);

        for (int i = 0; i < 500; i++) {
            mapper.insert(new DeviceInfo("123456", "沪A999" + i, new DeviceType((byte) 7, "SP5I"), "V1.0.1", "V1.0.1", "V1.0.1"));
        }

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteByTerminalSerialNumber() {
        SqlSession sqlSession = SqlUtils.getSqlSession();
        DeviceInfoMapper mapper = sqlSession.getMapper(DeviceInfoMapper.class);
        int deleteCount = mapper.deleteByTerminalSerialNumber("123456");

        System.out.println(deleteCount);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void update() {
        SqlSession sqlSession = SqlUtils.getSqlSession();
        DeviceInfoMapper mapper = sqlSession.getMapper(DeviceInfoMapper.class);
        int updateCount = mapper.update(new DeviceInfo("123456", "沪A999999", new DeviceType((byte) 8, "C720X"), "V1.0.2", "V1.0.1", "V1.0.1"));

        System.out.println(updateCount);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void getByTerminalSerialNumber() {
        SqlSession sqlSession = SqlUtils.getSqlSession();
        DeviceInfoMapper mapper = sqlSession.getMapper(DeviceInfoMapper.class);
        DeviceInfo deviceInfo = mapper.getByTerminalSerialNumber("123456");

        System.out.println(deviceInfo);

        sqlSession.close();
    }

    @Test
    public void getByPage() {
        SqlSession sqlSession = SqlUtils.getSqlSession();
        DeviceInfoMapper mapper = sqlSession.getMapper(DeviceInfoMapper.class);
        List<DeviceInfo> infoList = mapper.getByPage(0, 20);

        System.out.println(infoList);

        sqlSession.close();
    }
}
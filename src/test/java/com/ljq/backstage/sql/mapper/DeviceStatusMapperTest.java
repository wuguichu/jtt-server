package com.ljq.backstage.sql.mapper;

import com.ljq.backstage.sql.entity.DeviceStatus;
import com.ljq.backstage.sql.utils.SqlUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Calendar;

public class DeviceStatusMapperTest {

    @Test
    public void insert() {
        SqlSession sqlSession = SqlUtils.getSqlSession();
        DeviceStatusMapper mapper = sqlSession.getMapper(DeviceStatusMapper.class);

        DeviceStatus deviceStatus = new DeviceStatus();
        deviceStatus.setTerminalSerialNumber("012345678912");
        deviceStatus.setPowerOnStatus(true);
        deviceStatus.setAccStatus((short) 0);

        for (int i = 0; i < 50; i++) {
            deviceStatus.setTime(Calendar.getInstance().getTime().getTime() / 1000 - 10 * i);
            mapper.insert(deviceStatus);
        }

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void update() {
        SqlSession sqlSession = SqlUtils.getSqlSession();
        DeviceStatusMapper mapper = sqlSession.getMapper(DeviceStatusMapper.class);

        DeviceStatus deviceStatus = new DeviceStatus();
        deviceStatus.setTerminalSerialNumber("012594");
        deviceStatus.setPowerOnStatus(true);
        deviceStatus.setTime((long) 1254974949);
        deviceStatus.setAccStatus((short) 1);
        deviceStatus.setAdasAuthorization((short) 1);

        int updateCount = mapper.update(deviceStatus);
        System.out.println(updateCount);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void getByTerminalSerialNumberAndTime() {
        SqlSession sqlSession = SqlUtils.getSqlSession();
        DeviceStatusMapper mapper = sqlSession.getMapper(DeviceStatusMapper.class);

        DeviceStatus deviceStatus = mapper.getByTerminalSerialNumberAndTime("012594", (long) 1254974949);
        System.out.println(deviceStatus);

        sqlSession.close();
    }
}
package com.ljq.backstage.sql.mapper;

import com.ljq.backstage.sql.entity.DeviceStatus;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Calendar;

public class DeviceStatusMapperImplTest {

    @Test
    public void insert() {
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        DeviceStatusMapper mapper = context.getBean("deviceStatusMapper", DeviceStatusMapper.class);

        DeviceStatus deviceStatus = new DeviceStatus();
        deviceStatus.setTerminalSerialNumber("012345678912");
        deviceStatus.setPowerOnStatus(true);
        deviceStatus.setAccStatus((short) 0);

        for (int i = 0; i < 50; i++) {
            deviceStatus.setTime(Calendar.getInstance().getTime().getTime() / 1000 - 10 * i);
            mapper.insert(deviceStatus);
        }
    }

    @Test
    public void update() {
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        DeviceStatusMapper mapper = context.getBean("deviceStatusMapper", DeviceStatusMapper.class);

        DeviceStatus deviceStatus = new DeviceStatus();
        deviceStatus.setTerminalSerialNumber("012594");
        deviceStatus.setPowerOnStatus(true);
        deviceStatus.setTime((long) 1254974949);
        deviceStatus.setAccStatus((short) 1);
        deviceStatus.setAdasAuthorization((short) 1);

        int updateCount = mapper.update(deviceStatus);
        System.out.println(updateCount);
    }

    @Test
    public void getByTerminalSerialNumberAndTime() {
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        DeviceStatusMapper mapper = context.getBean("deviceStatusMapper", DeviceStatusMapper.class);

        DeviceStatus deviceStatus = mapper.getByTerminalSerialNumberAndTime("012594", (long) 1254974949);
        System.out.println(deviceStatus);
    }
}
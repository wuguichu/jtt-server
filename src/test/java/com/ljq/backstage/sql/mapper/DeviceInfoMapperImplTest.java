package com.ljq.backstage.sql.mapper;

import com.ljq.backstage.sql.entity.DeviceInfo;
import com.ljq.backstage.sql.entity.DeviceType;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class DeviceInfoMapperImplTest {

    @Test
    public void insert() {
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        DeviceInfoMapper mapper = context.getBean("deviceInfoMapper", DeviceInfoMapper.class);
        mapper.insert(new DeviceInfo("123456", "苏A123456", new DeviceType((byte) 1, "sljo"), "v1.01", "v1.01", "v1.01"));
    }

    @Test
    public void deleteByTerminalSerialNumber() {
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        DeviceInfoMapper mapper = context.getBean("deviceInfoMapper", DeviceInfoMapper.class);
        mapper.deleteByTerminalSerialNumber("123456");
    }

    @Test
    public void update() {
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        DeviceInfoMapper mapper = context.getBean("deviceInfoMapper", DeviceInfoMapper.class);
        mapper.update(new DeviceInfo("123456", "苏A123456", new DeviceType((byte) 1, "sljo"), "v2", "v1.01", "v1.01"));
    }

    @Test
    public void getByTerminalSerialNumber() {
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        DeviceInfoMapper mapper = context.getBean("deviceInfoMapper", DeviceInfoMapper.class);
        DeviceInfo byTerminalSerialNumber = mapper.getByTerminalSerialNumber("123456");
        System.out.println(byTerminalSerialNumber);
    }

    @Test
    public void getByPage() {
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        DeviceInfoMapper mapper = context.getBean("deviceInfoMapper", DeviceInfoMapper.class);
        List<DeviceInfo> byPage = mapper.getByPage(0, 20);
        byPage.forEach(System.out::println);
    }
}
package com.ljq.backstage.sql.mapper;

import com.ljq.backstage.sql.entity.DeviceType;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class DeviceTypeMapperImplTest {

    @Test
    public void insert() {
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        DeviceTypeMapper mapper = context.getBean("deviceTypeMapper", DeviceTypeMapper.class);
        mapper.insert(new DeviceType((byte) 9, "BK6I"));
    }

    @Test
    public void delete() {
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        DeviceTypeMapper mapper = context.getBean("deviceTypeMapper", DeviceTypeMapper.class);
        mapper.delete(new DeviceType((byte) 1, "BK6I"));
    }

    @Test
    public void getByTypeName() {
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        DeviceTypeMapper mapper = context.getBean("deviceTypeMapper", DeviceTypeMapper.class);
        DeviceType bk6I = mapper.getByTypeName("BK6I");
        System.out.println(bk6I);
    }

    @Test
    public void get() {
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        DeviceTypeMapper mapper = context.getBean("deviceTypeMapper", DeviceTypeMapper.class);
        List<DeviceType> deviceTypes = mapper.get();
        deviceTypes.forEach(System.out::println);
    }
}
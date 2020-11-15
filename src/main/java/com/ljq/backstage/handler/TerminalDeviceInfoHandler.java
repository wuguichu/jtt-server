package com.ljq.backstage.handler;

import com.ljq.backstage.sql.entity.DeviceInfo;
import com.ljq.backstage.sql.entity.DeviceType;
import com.ljq.backstage.sql.mapper.DeviceInfoMapper;
import com.ljq.backstage.sql.mapper.DeviceTypeMapper;
import com.ljq.framework.codec.AbstractInstruction;
import com.ljq.framework.handler.AbstractHandler;
import com.ljq.framework.handler.HandlerMap;
import com.ljq.framework.handler.JttSession;
import com.ljq.framework.utils.BCDTransform;
import com.ljq.protocol.basic.BasicId;
import com.ljq.protocol.basic.TerminalDeviceInfo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@HandlerMap(BasicId.VEHICLE_DEVICE_INFO)
public class TerminalDeviceInfoHandler extends AbstractHandler<TerminalDeviceInfo> {
    @Override
    protected AbstractInstruction handleDeviceMessage(JttSession session, TerminalDeviceInfo message) {
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");

        DeviceTypeMapper deviceTypemapper = context.getBean("deviceTypeMapper", DeviceTypeMapper.class);
        DeviceType deviceType = deviceTypemapper.getByTypeName(message.getDeviceType());
        if (deviceType == null) {
            deviceTypemapper.insert(new DeviceType((byte) 1, message.getDeviceType()));
            deviceType = deviceTypemapper.getByTypeName(message.getDeviceType());
        }

        DeviceInfoMapper deviceInfoMapper = context.getBean("deviceInfoMapper", DeviceInfoMapper.class);
        DeviceInfo deviceInfo = deviceInfoMapper.getByTerminalSerialNumber(BCDTransform.toString(message.getHeader().getTerminalNum()));
        if (deviceInfo == null)
            deviceInfoMapper.insert(new DeviceInfo(BCDTransform.toString(message.getHeader().getTerminalNum()), message.getCarLicense(), deviceType, message.getAppVersion(), message.getMcuVersion(), message.getAiVersion()));
        else {
            deviceInfo.getDeviceType().setTypeName(message.getDeviceType());
            deviceInfo.setAppVersion(message.getAppVersion());
            deviceInfo.setMcuVersion(message.getMcuVersion());
            deviceInfo.setAiVersion(message.getAiVersion());

            deviceInfoMapper.update(deviceInfo);
        }

        return responseTerminal(message.getHeader().getInstruction(), 0);
    }
}
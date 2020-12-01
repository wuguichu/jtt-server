package com.ljq.backstage.handler;

import com.ljq.backstage.sql.entity.DeviceStatus;
import com.ljq.backstage.sql.mapper.DeviceStatusMapper;
import com.ljq.backstage.sql.utils.DeviceStatusUtils;
import com.ljq.framework.codec.AbstractInstruction;
import com.ljq.framework.handler.AbstractHandler;
import com.ljq.framework.handler.HandlerMap;
import com.ljq.framework.handler.JttSession;
import com.ljq.framework.utils.BCDTransform;
import com.ljq.protocol.basic.BasicId;
import com.ljq.protocol.basic.TerminalStatusChange;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@HandlerMap(BasicId.TERMINAL_STATUS_CHANGE)
public class TerminalStatusChangeHandler extends AbstractHandler<TerminalStatusChange> {

    @Override
    protected AbstractInstruction handleDeviceMessage(JttSession session, TerminalStatusChange message) {
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");

        DeviceStatusMapper mapper = context.getBean("deviceStatusMapper", DeviceStatusMapper.class);
        DeviceStatus deviceStatus = mapper.getByTerminalSerialNumberAndTime(BCDTransform.toString(message.getHeader().getTerminalNum()), message.getTimeInfo().getTime());
        if (deviceStatus == null) {
            mapper.insert(DeviceStatusUtils.getDeviceStatusByChangeStatus(message));
        } else {
            mapper.update(DeviceStatusUtils.getDeviceStatusDiffByChangeStatus(message, deviceStatus));
        }

        return responseTerminal(message.getHeader().getInstruction(), 0);
    }

}
package com.ljq.backstage.handler;

import com.ljq.framework.codec.AbstractInstruction;
import com.ljq.framework.handler.AbstractHandler;
import com.ljq.framework.handler.HandlerMap;
import com.ljq.framework.handler.JttSession;
import com.ljq.protocol.basic.BasicId;
import com.ljq.protocol.basic.TerminalDeviceInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

@HandlerMap(BasicId.VEHICLE_DEVICE_INFO)
public class TerminalDeviceInfoHandler extends AbstractHandler<TerminalDeviceInfo> {
    @Override
    protected AbstractInstruction handleDeviceMessage(JttSession session, TerminalDeviceInfo message) {
        return responseTerminal(message.getHeader().getInstruction(), 0);
    }
}
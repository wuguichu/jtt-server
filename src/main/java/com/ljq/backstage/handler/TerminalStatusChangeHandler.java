package com.ljq.backstage.handler;

import com.ljq.framework.codec.AbstractInstruction;
import com.ljq.framework.handler.AbstractHandler;
import com.ljq.framework.handler.HandlerMap;
import com.ljq.framework.handler.JttSession;
import com.ljq.protocol.basic.BasicId;
import com.ljq.protocol.basic.TerminalStatusChange;
import com.ljq.protocol.basic.attribute.LocationInfo;
import com.ljq.protocol.basic.attribute.TimeInfo;

import java.sql.*;

@HandlerMap(BasicId.TERMINAL_STATUS_CHANGE)
public class TerminalStatusChangeHandler extends AbstractHandler<TerminalStatusChange> {

    @Override
    protected AbstractInstruction handleDeviceMessage(JttSession session, TerminalStatusChange message) {
        return responseTerminal(message.getHeader().getInstruction(), 0);
    }

}
package com.ljq.backstage.handler;

import com.ljq.framework.codec.AbstractInstruction;
import com.ljq.framework.handler.AbstractHandler;
import com.ljq.framework.handler.HandlerMap;
import com.ljq.framework.handler.JttSession;
import com.ljq.protocol.basic.BasicId;
import com.ljq.protocol.basic.TerminalOnlineResp;

@HandlerMap(BasicId.TERMINAL_ONLINE)
public class TerminalOnlineHandler extends AbstractHandler {
    @Override
    protected <T extends AbstractInstruction> AbstractInstruction handleDeviceMessage(JttSession session, T message) {
        TerminalOnlineResp terminalOnlineResp = new TerminalOnlineResp();

        terminalOnlineResp.setErrorCode(0);

        session.setOnlineStatus(true);

        return terminalOnlineResp;
    }
}

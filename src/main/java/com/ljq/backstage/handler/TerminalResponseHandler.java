package com.ljq.backstage.handler;

import com.ljq.framework.codec.AbstractInstruction;
import com.ljq.framework.handler.AbstractHandler;
import com.ljq.framework.handler.HandlerMap;
import com.ljq.framework.handler.JttSession;
import com.ljq.protocol.basic.BasicId;

@HandlerMap(BasicId.TERMINAL_RESPONSE)
public class TerminalResponseHandler extends AbstractHandler {
    @Override
    protected <T extends AbstractInstruction> AbstractInstruction handleDeviceMessage(JttSession session, T message) {
        // do nothing
        return null;
    }
}

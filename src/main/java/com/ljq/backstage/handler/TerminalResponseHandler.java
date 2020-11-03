package com.ljq.backstage.handler;

import com.ljq.framework.codec.AbstractInstruction;
import com.ljq.framework.handler.AbstractHandler;
import com.ljq.framework.handler.HandlerMap;
import com.ljq.framework.handler.JttSession;
import com.ljq.protocol.basic.BasicId;
import com.ljq.protocol.basic.TerminalResponse;

@HandlerMap(BasicId.TERMINAL_RESPONSE)
public class TerminalResponseHandler extends AbstractHandler<TerminalResponse> {
    @Override
    protected AbstractInstruction handleDeviceMessage(JttSession session, TerminalResponse message) {
        // do nothing
        return null;
    }
}

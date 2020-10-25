package com.ljq.backstage.handler;

import com.ljq.framework.codec.AbstractInstruction;
import com.ljq.framework.handler.AbstractHandler;
import com.ljq.framework.handler.HandlerMap;
import com.ljq.framework.handler.JttSession;
import com.ljq.protocol.basic.BasicId;
import com.ljq.protocol.basic.CenterHeartBeat;

@HandlerMap(BasicId.TERMINAL_HEARTBEAT)
public class TerminalHeartBeatHandler extends AbstractHandler {
    @Override
    protected <T extends AbstractInstruction> AbstractInstruction handleDeviceMessage(JttSession session, T message) {
        return new CenterHeartBeat();
    }
}

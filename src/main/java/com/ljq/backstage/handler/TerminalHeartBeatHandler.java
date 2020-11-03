package com.ljq.backstage.handler;

import com.ljq.framework.codec.AbstractInstruction;
import com.ljq.framework.handler.AbstractHandler;
import com.ljq.framework.handler.HandlerMap;
import com.ljq.framework.handler.JttSession;
import com.ljq.protocol.basic.BasicId;
import com.ljq.protocol.basic.CenterHeartBeat;
import com.ljq.protocol.basic.TerminalHeartBeat;

@HandlerMap(BasicId.TERMINAL_HEARTBEAT)
public class TerminalHeartBeatHandler extends AbstractHandler<TerminalHeartBeat> {
    @Override
    protected AbstractInstruction handleDeviceMessage(JttSession session, TerminalHeartBeat message) {
        return new CenterHeartBeat();
    }
}

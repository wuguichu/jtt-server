package com.ljq.backstage.handler;

import com.ljq.framework.codec.AbstractInstruction;
import com.ljq.framework.handler.AbstractHandler;
import com.ljq.framework.handler.HandlerMap;
import com.ljq.framework.handler.JttSession;
import com.ljq.protocol.basic.BasicId;

@HandlerMap({BasicId.REAL_TIME_TRACK_REPORT})
public class GeneralResponseHandler<T extends AbstractInstruction> extends AbstractHandler<T> {
    @Override
    protected AbstractInstruction handleDeviceMessage(JttSession session, T message) {
        return responseTerminal(message.getHeader().getInstruction(), 0);
    }
}

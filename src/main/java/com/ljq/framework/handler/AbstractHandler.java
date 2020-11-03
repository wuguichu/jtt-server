package com.ljq.framework.handler;

import com.ljq.framework.codec.AbstractInstruction;
import com.ljq.framework.utils.BCDTransform;
import com.ljq.protocol.basic.BasicId;
import com.ljq.protocol.basic.CenterResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class AbstractHandler<T extends AbstractInstruction> {
    protected abstract AbstractInstruction handleDeviceMessage(JttSession session, T message);

    public AbstractInstruction handleMessage(JttSession session, AbstractInstruction message) {
        if (session == null || message == null)
            return null;
        AbstractInstruction response;

        if (!session.getAuthStatus() && message.getHeader().getInstruction() != BasicId.TERMINAL_AUTH) {
            log.warn("终端 {} 未认证就请求其他指令：0x{}", BCDTransform.toString(message.getHeader().getTerminalNum()), Long.toHexString(message.getHeader().getInstruction()));
            response = responseTerminal(message.getHeader().getInstruction(), -1);
        } else if (!session.getOnlineStatus() && message.getHeader().getInstruction() != BasicId.TERMINAL_ONLINE && message.getHeader().getInstruction() != BasicId.TERMINAL_AUTH) {
            log.warn("终端 {} 未上线就请求其他指令：0x{}", BCDTransform.toString(message.getHeader().getTerminalNum()), Long.toHexString(message.getHeader().getInstruction()));
            response = responseTerminal(message.getHeader().getInstruction(), -1);
        } else
            response = handleDeviceMessage(session, (T) message);

        if (null != response) {
            response.getHeader().setSerialNo(session.getSerialNo());
            response.getHeader().setTerminalNum(session.getTerminalNum());
        }

        return response;
    }

    protected CenterResponse responseTerminal(long instruction, int errorCode) {
        CenterResponse centerResponse = new CenterResponse();
        centerResponse.setInstruction(instruction);
        centerResponse.setErrorCode(errorCode);
        return centerResponse;
    }

    protected static final Logger log = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
}

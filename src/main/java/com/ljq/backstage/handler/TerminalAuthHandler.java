package com.ljq.backstage.handler;

import com.ljq.framework.codec.AbstractInstruction;
import com.ljq.framework.handler.AbstractHandler;
import com.ljq.framework.handler.HandlerMap;
import com.ljq.framework.handler.JttSession;
import com.ljq.protocol.basic.BasicId;
import com.ljq.protocol.basic.TerminalAuthResp;

@HandlerMap(BasicId.TERMINAL_AUTH)
public class TerminalAuthHandler extends AbstractHandler {
    @Override
    protected <T extends AbstractInstruction> AbstractInstruction handleDeviceMessage(JttSession session, T message) {
        TerminalAuthResp terminalAuthResp = new TerminalAuthResp();

        terminalAuthResp.setErrorCode(0);
        terminalAuthResp.setVerificationCode("");//"123456789"
        terminalAuthResp.setIpVersion(0);
        terminalAuthResp.setAddrFmt(0);
        terminalAuthResp.setPort(0);
        terminalAuthResp.setIpAddress("");//"192.168.1.186"	"192.168.1.199"

        session.setAuthStatus(true);
        session.setTerminalNum(message.getHeader().getTerminalNum());

        return terminalAuthResp;
    }
}

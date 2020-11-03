package com.ljq.backstage.handler;

import com.ljq.framework.codec.AbstractInstruction;
import com.ljq.framework.handler.AbstractHandler;
import com.ljq.framework.handler.HandlerMap;
import com.ljq.framework.handler.JttSession;
import com.ljq.protocol.basic.BasicId;
import com.ljq.protocol.basic.TerminalAuth;
import com.ljq.protocol.basic.TerminalAuthResp;

@HandlerMap(BasicId.TERMINAL_AUTH)
public class TerminalAuthHandler extends AbstractHandler<TerminalAuth> {
    @Override
    protected AbstractInstruction handleDeviceMessage(JttSession session, TerminalAuth message) {
        TerminalAuthResp terminalAuthResp = new TerminalAuthResp();

        terminalAuthResp.setErrorCode(0);
        terminalAuthResp.setVerificationCode("");
        terminalAuthResp.setIpVersion(0);
        terminalAuthResp.setAddrFmt(0);
        terminalAuthResp.setPort(0);
        terminalAuthResp.setIpAddress("");

        session.setAuthStatus(true);
        session.setTerminalNum(message.getHeader().getTerminalNum());

        return terminalAuthResp;
    }
}

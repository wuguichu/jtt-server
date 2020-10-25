package com.ljq.framework.handler;

import io.netty.channel.Channel;
import io.netty.util.AttributeKey;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.atomic.AtomicInteger;

public class JttSession {

    public JttSession(Channel channel) {
        this.channel = channel;
    }

    public byte[] getTerminalNum() {
        return terminalNum;
    }

    public void setTerminalNum(byte[] terminalNum) {
        this.terminalNum = terminalNum;
    }

    public int getSerialNo() {
        int current = serialNo.get();
        serialNo.set(current + 1 > 0xffff ? 0 : current + 1);
        return current;
    }

    public boolean getAuthStatus() {
        return (status & (0x01)) != 0;
    }

    public void setAuthStatus(boolean status) {
        if (status)
            this.status |= 0x01;
        else
            this.status &= (~0x01);
    }

    public boolean getOnlineStatus() {
        return (status & (0x01 << 1)) != 0;
    }

    public void setOnlineStatus(boolean status) {
        if (status)
            this.status |= (0x01 << 1);
        else
            this.status &= (~(0x01 << 1));
    }

    public static final AttributeKey<JttSession> KEY = AttributeKey.newInstance(JttSession.class.getName());

    private final Channel channel;
    private byte status;
    private final AtomicInteger serialNo = new AtomicInteger(0);
    private byte[] terminalNum;
    private static final Logger log = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
}

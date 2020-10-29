package com.ljq.protocol.basic.attribute;

import java.util.Arrays;

public class BaseStatusChannel {
    public BaseStatusChannel() {
        channelStatus = new short[16];

        Arrays.fill(channelStatus, (short) 0xff);
    }

    public short[] getChannelStatus() {
        return channelStatus;
    }

    public void setChannelStatus(short[] channelStatus) {
        this.channelStatus = channelStatus;
    }

    @Override
    public String toString() {
        return "BaseStatusChannel{" +
                "channelStatus=" + Arrays.toString(channelStatus) +
                '}';
    }

    private short[] channelStatus;
}
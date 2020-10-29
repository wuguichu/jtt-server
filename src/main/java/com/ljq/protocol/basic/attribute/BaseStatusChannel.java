package com.ljq.protocol.basic.attribute;

import java.util.Arrays;

public class BaseStatusChannel {
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
package com.ljq.protocol.basic;

import com.ljq.framework.codec.AbstractInstruction;
import com.ljq.framework.codec.Instruction;

@Instruction(BasicId.CENTER_HEARTBEAT)
public class CenterHeartBeat extends AbstractInstruction {
    @Override
    public String toString() {
        return "CenterHeartBeat{" +
                "header=" + header +
                '}';
    }
}

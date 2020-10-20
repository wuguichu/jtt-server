package com.ljq.protocol.basic;

import com.ljq.framework.codec.AbstractInstruction;
import com.ljq.framework.codec.Instruction;

@Instruction(BasicId.TERMINAL_HEARTBEAT)
public class TerminalHeartBeat extends AbstractInstruction {
    @Override
    public String toString() {
        return "TerminalHeartBeat{" +
                "header=" + header +
                '}';
    }
}

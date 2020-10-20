package com.ljq.protocol.basic;

import com.ljq.framework.codec.AbstractInstruction;
import com.ljq.framework.codec.Field;
import com.ljq.framework.codec.Instruction;
import com.ljq.framework.fields.FieldType;

@Instruction(BasicId.CENTER_HEARTBEAT)
public class CenterHeartBeat extends AbstractInstruction {
	@Override
    public String toString() {
        return "CenterHeartBeat{" +
                "header=" + header +
                '}';
    }
}

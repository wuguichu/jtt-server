package com.ljq.protocol.basic;

import com.ljq.framework.codec.AbstractInstruction;
import com.ljq.framework.codec.Field;
import com.ljq.framework.codec.Instruction;
import com.ljq.framework.fields.FieldType;

@Instruction(BasicId.TERMINAL_ONLINE_RESP)
public class TerminalOnlineResp extends AbstractInstruction {
    @Field(index = 0, type = FieldType.INT32)
    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    @Override
    public String toString() {
        return "TerminalOnlineResp{" +
                "errorCode=" + errorCode +
                ", header=" + header +
                '}';
    }

    private int errorCode;
}

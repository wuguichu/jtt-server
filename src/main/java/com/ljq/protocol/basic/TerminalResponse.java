package com.ljq.protocol.basic;

import com.ljq.framework.codec.AbstractInstruction;
import com.ljq.framework.codec.Field;
import com.ljq.framework.codec.Instruction;
import com.ljq.framework.fields.FieldType;

@Instruction(BasicId.TERMINAL_RESPONSE)
public class TerminalResponse extends AbstractInstruction {
    @Field(index = 0, type = FieldType.UINT32)
    public Long getInstruction() {
        return instruction;
    }

    public void setInstruction(Long instruction) {
        this.instruction = instruction;
    }

    @Field(index = 1, type = FieldType.INT32)
    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    @Field(index = 2, type = FieldType.INT16)
    public Short getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Short serialNo) {
        this.serialNo = serialNo;
    }

    @Override
    public String toString() {
        return "TerminalResponse{" +
                "instruction=" + instruction +
                ", errorCode=" + errorCode +
                ", serialNo=" + serialNo +
                ", header=" + header +
                '}';
    }

    private Long instruction;
    private Integer errorCode;
    private Short serialNo;
}

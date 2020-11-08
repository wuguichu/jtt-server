package com.ljq.protocol.basic;

import com.ljq.framework.codec.AbstractInstruction;
import com.ljq.framework.codec.Field;
import com.ljq.framework.codec.Instruction;
import com.ljq.framework.fields.FieldType;

@Instruction(BasicId.UPGRADE_STATUS)
public class ShellCommandResult extends AbstractInstruction {
    @Field(index = 0, type = FieldType.UINT8)
    public short getSign() {
        return sign;
    }

    public void setSign(short sign) {
        this.sign = sign;
    }

    @Field(index = 1, type = FieldType.UINT16)
    public int getPackageSequence() {
        return packageSequence;
    }

    public void setPackageSequence(int packageSequence) {
        this.packageSequence = packageSequence;
    }

    @Field(index = 2, type = FieldType.UINT32)
    public long getTimeSign() {
        return timeSign;
    }

    public void setTimeSign(long timeSign) {
        this.timeSign = timeSign;
    }

    @Field(index = 3, type = FieldType.INT32STRING)
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ShellCommandResult{" +
                "sign='" + sign + '\'' +
                ", packageSequence='" + packageSequence + '\'' +
                ", timeSign='" + timeSign + '\'' +
                ", data='" + data + '\'' +
                ", header=" + header +
                '}';
    }

    private short sign;
    private int packageSequence;
    private long timeSign;
    private String data;
}

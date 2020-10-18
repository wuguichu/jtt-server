package com.ljq.protocol.basic;

import com.ljq.framework.codec.AbstractInstruction;
import com.ljq.framework.codec.Field;
import com.ljq.framework.codec.Instruction;
import com.ljq.framework.fields.FieldType;

import java.util.Arrays;

@Instruction(BasicId.TERMINAL_AUTH)
public class TerminalAuth extends AbstractInstruction {
    @Field(index = 0, type = FieldType.BCD, length = 6)
    public byte[] getBcdTerminalSerial() {
        return bcdTerminalSerial;
    }

    public void setBcdTerminalSerial(byte[] bcdTerminalSerial) {
        this.bcdTerminalSerial = bcdTerminalSerial;
    }

    @Field(index = 1, type = FieldType.RESERVE, length = 2)
    public Byte getReserve() {
        return reserve;
    }

    public void setReserve(Byte reserve) {
        this.reserve = reserve;
    }

    @Field(index = 2, type = FieldType.FIXEDSTRING, length = 32)
    public String getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(String manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    @Override
    public String toString() {
        return "TerminalAuth{" +
                "bcdTerminalSerial=" + Arrays.toString(bcdTerminalSerial) +
                ", reserve=" + reserve +
                ", manufacturerId='" + manufacturerId + '\'' +
                ", header=" + header +
                '}';
    }

    private byte[] bcdTerminalSerial;
    private Byte reserve;
    private String manufacturerId;
}

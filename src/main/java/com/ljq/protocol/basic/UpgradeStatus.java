package com.ljq.protocol.basic;

import com.ljq.framework.codec.AbstractInstruction;
import com.ljq.framework.codec.Field;
import com.ljq.framework.codec.Instruction;
import com.ljq.framework.fields.FieldType;

@Instruction(BasicId.UPGRADE_STATUS)
public class UpgradeStatus extends AbstractInstruction {
    @Field(index = 0, type = FieldType.UINT8)
    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "UpgradeStatus{" +
                "status='" + status + '\'' +
                ", header=" + header +
                '}';
    }

    private short status;
}

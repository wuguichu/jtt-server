package com.ljq.protocol.basic;

import com.ljq.framework.codec.AbstractInstruction;
import com.ljq.framework.codec.Field;
import com.ljq.framework.codec.Instruction;
import com.ljq.framework.fields.FieldType;

@Instruction(BasicId.REAL_TIME_TRACK)
public class RealTimeTrack extends AbstractInstruction {
    @Field(index = 0, type = FieldType.UINT8)
    public short getControlSwitch() {
        return controlSwitch;
    }

    public void setControlSwitch(short controlSwitch) {
        this.controlSwitch = controlSwitch;
    }

    @Field(index = 1, type = FieldType.UINT8)
    public short getReportInterval() {
        return reportInterval;
    }

    public void setReportInterval(short reportInterval) {
        this.reportInterval = reportInterval;
    }

    @Override
    public String toString() {
        return "RealTimeTrack{" +
                "controlSwitch='" + controlSwitch + '\'' +
                ", reportInterval='" + reportInterval + '\'' +
                ", header=" + header +
                '}';
    }

    private short controlSwitch;
    private short reportInterval;
}

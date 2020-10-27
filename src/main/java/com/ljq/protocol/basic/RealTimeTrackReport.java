package com.ljq.protocol.basic;

import com.ljq.framework.codec.AbstractInstruction;
import com.ljq.framework.codec.Field;
import com.ljq.framework.codec.Instruction;
import com.ljq.framework.fields.FieldType;
import com.ljq.protocol.basic.attribute.LocationInfo;
import com.ljq.protocol.basic.attribute.TimeInfo;

@Instruction(BasicId.REAL_TIME_TRACK_REPORT)
public class RealTimeTrackReport extends AbstractInstruction {
    @Field(index = 0, type = FieldType.SUBTYPE)
    public TimeInfo getTimeInfo() {
        return timeInfo;
    }

    public void setTimeInfo(TimeInfo timeInfo) {
        this.timeInfo = timeInfo;
    }

    @Field(index = 1, type = FieldType.SUBTYPE)
    public LocationInfo getLocationInfo() {
        return locationInfo;
    }

    public void setLocationInfo(LocationInfo locationInfo) {
        this.locationInfo = locationInfo;
    }

    @Field(index = 2, type = FieldType.UINT8)
    public short getGsensorStatus() {
        return gsensorStatus;
    }

    public void setGsensorStatus(short gsensorStatus) {
        this.gsensorStatus = gsensorStatus;
    }

    @Field(index = 3, type = FieldType.UINT16)
    public int getVoltage() {
        return voltage;
    }

    public void setVoltage(int voltage) {
        this.voltage = voltage;
    }

    @Field(index = 4, type = FieldType.INT16)
    public short getTemperature() {
        return temperature;
    }

    public void setTemperature(short temperature) {
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return "RealTimeTrackReport{" +
                "timeInfo='" + timeInfo + '\'' +
                ", locationInfo='" + locationInfo + '\'' +
                ", gsensorStatus='" + gsensorStatus + '\'' +
                ", voltage=" + voltage +
                ", temperature='" + temperature + '\'' +
                ", header=" + header +
                '}';
    }

    private TimeInfo timeInfo;
    private LocationInfo locationInfo;
    private short gsensorStatus;
    private int voltage;
    private short temperature;
}

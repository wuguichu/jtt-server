package com.ljq.protocol.basic.attribute;

import com.ljq.framework.codec.Field;
import com.ljq.framework.fields.FieldType;

public class LocationInfo {
    @Field(index = 0, type = FieldType.UINT32)
    public long getSystemStatus() {
        return systemStatus;
    }

    public void setSystemStatus(long systemStatus) {
        this.systemStatus = systemStatus;
    }

    @Field(index = 1, type = FieldType.UINT16)
    public int getChannelStatus() {
        return channelStatus;
    }

    public void setChannelStatus(int channelStatus) {
        this.channelStatus = channelStatus;
    }

    @Field(index = 2, type = FieldType.UINT16)
    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Field(index = 3, type = FieldType.INT16)
    public short getHigh() {
        return high;
    }

    public void setHigh(short high) {
        this.high = high;
    }

    @Field(index = 4, type = FieldType.UINT16)
    public int getDirectionAngle() {
        return directionAngle;
    }

    public void setDirectionAngle(int directionAngle) {
        this.directionAngle = directionAngle;
    }

    @Field(index = 5, type = FieldType.INT64)
    public long getLongitude() {
        return longitude;
    }

    public void setLongitude(long longitude) {
        this.longitude = longitude;
    }

    @Field(index = 6, type = FieldType.INT64)
    public long getLatitude() {
        return latitude;
    }

    public void setLatitude(long latitude) {
        this.latitude = latitude;
    }

    @Override
    public String toString() {
        return "LocationInfo{" +
                "systemStatus=" + systemStatus +
                ", channelStatus=" + channelStatus +
                ", speed=" + speed +
                ", high=" + high +
                ", directionAngle=" + directionAngle +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                '}';
    }

    private long systemStatus;
    private int channelStatus;
    private int speed;
    private short high;
    private int directionAngle;
    private long longitude;
    private long latitude;
}

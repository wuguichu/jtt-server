package com.ljq.protocol.basic.attribute;

import com.ljq.framework.codec.Field;
import com.ljq.framework.fields.FieldType;

public class LocationInfo {
    @Field(index = 0, type = FieldType.UINT32)
    public Long getSystemStatus() {
        return systemStatus;
    }

    public void setSystemStatus(Long systemStatus) {
        this.systemStatus = systemStatus;
    }

    @Field(index = 1, type = FieldType.UINT16)
    public Integer getChannelStatus() {
        return channelStatus;
    }

    public void setChannelStatus(Integer channelStatus) {
        this.channelStatus = channelStatus;
    }

    @Field(index = 2, type = FieldType.UINT16)
    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    @Field(index = 3, type = FieldType.INT32)
    public Short getHigh() {
        return high;
    }

    public void setHigh(Short high) {
        this.high = high;
    }

    @Field(index = 4, type = FieldType.UINT8)
    public Integer getDirectionAngle() {
        return directionAngle;
    }

    public void setDirectionAngle(Integer directionAngle) {
        this.directionAngle = directionAngle;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
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

    private Long systemStatus;
    private Integer channelStatus;
    private Integer speed;
    private Short high;
    private Integer directionAngle;
    private Double longitude;
    private Double latitude;
}

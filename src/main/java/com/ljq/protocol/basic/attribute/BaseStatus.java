package com.ljq.protocol.basic.attribute;

public class BaseStatus {
    @Field(index = 0, type = FieldType.UINT32)
    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    @Field(index = 1, type = FieldType.UINT8)
    public short getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(short timeZone) {
        this.timeZone = timeZone;
    }

    @Field(index = 2, type = FieldType.RESERVE, length = 3)
    public Byte getReserve() {
        return reserve;
    }

    public void setReserve(Byte reserve) {
        this.reserve = reserve;
    }

    @Override
    public String toString() {
        return "TimeInfo{" +
                "time=" + time +
                ", timeZone=" + timeZone +
                ", reserve=" + reserve +
                '}';
    }

    private short gpsStatus;
    private short udiskStatus;
	private short ummcStatus;
	private short channelStatus;
	private short recordStatus;
}

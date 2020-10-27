package com.ljq.protocol.basic;

import com.ljq.framework.codec.AbstractInstruction;
import com.ljq.framework.codec.Field;
import com.ljq.framework.codec.Instruction;
import com.ljq.framework.codec.CustomCodec;
import com.ljq.framework.fields.FieldType;
import com.ljq.protocol.basic.attribute.TimeInfo;
import com.ljq.protocol.basic.attribute.LocationInfo;

@Instruction(BasicId.TERMINAL_STATUS_CHANGE)
public class TerminalStatusChange extends AbstractInstruction {
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

	@Field(index = 2, type = FieldType.UINT32)
    public long getStatusCount() {
        return statusCount;
    }

    public void setStatusCount(long statusCount) {
        this.statusCount = statusCount;
    }

	@Field(index = 3, type = FieldType.SELFCODEC)
    public long getStatusCount() {
        return statusCount;
    }

    public void setStatusCount(long statusCount) {
        this.statusCount = statusCount;
    }

    @Override
    public String toString() {
        return "TerminalStatusChange{" +
                "timeInfo='" + timeInfo + '\'' +
                ", locationInfo='" + locationInfo + '\'' +
                ", statusCount='" + statusCount + '\'' +
                ", header=" + header +
                '}';
    }

    private TimeInfo timeInfo;
	private LocationInfo locationInfo;
    private long statusCount;
}

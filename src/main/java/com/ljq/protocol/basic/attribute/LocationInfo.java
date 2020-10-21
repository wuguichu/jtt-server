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

	@Field(index = 1, type = FieldType.UINT8)
    public Short getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(Short timeZone) {
        this.timeZone = timeZone;
    }

	@Field(index = 2, type = FieldType.RESERVE, length = 3)
	public Byte getReserve() {
		return reserve;
	}

	public void setReserve(Byte reserve) {
		this.reserve = reserve;
	}

	private Long systemStatus;
	private Integer channelStatus;
	private Integer speed;
	private Short high;
	private Integer directionAngle;
	private Double longitude;
	private Double latitude;
}

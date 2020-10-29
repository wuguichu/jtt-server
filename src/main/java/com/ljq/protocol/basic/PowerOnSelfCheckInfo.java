package com.ljq.protocol.basic;

import com.ljq.framework.codec.AbstractInstruction;
import com.ljq.framework.codec.Field;
import com.ljq.framework.codec.Instruction;
import com.ljq.framework.fields.FieldType;
import com.ljq.protocol.basic.attribute.*;

@Instruction(BasicId.POWERON_SELF_CHECK_INFO)
public class PowerOnSelfCheckInfo extends AbstractInstruction {
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

	@Field(index = 2, type = FieldType.BASESTATUS)
	public BaseStatus getBaseStatus() {
		return baseStatus;
	}

	public void setBaseStatus(BaseStatus baseStatus) {
		this.baseStatus = baseStatus;
	}

	@Override
	public String toString() {
		return "PowerOnSelfCheckInfo{" +
				"timeInfo=" + timeInfo +
				", locationInfo=" + locationInfo +
				", baseStatus=" + baseStatus +
				", header=" + header +
				'}';
	}

	private TimeInfo timeInfo;
	private LocationInfo locationInfo;
	private BaseStatus baseStatus;
}


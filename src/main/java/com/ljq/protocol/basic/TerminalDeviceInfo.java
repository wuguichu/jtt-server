package com.ljq.protocol.basic;

import com.ljq.framework.codec.AbstractInstruction;
import com.ljq.framework.codec.Field;
import com.ljq.framework.codec.Instruction;
import com.ljq.framework.fields.FieldType;

@Instruction(BasicId.VEHICLE_DEVICE_INFO)
public class TerminalDeviceInfo extends AbstractInstruction {
    @Field(index = 0, type = FieldType.FIXEDSTRING, length = 12)
    public String getCarLicense() {
        return carLicense;
    }

    public void setCarLicense(String carLicense) {
        this.carLicense = carLicense;
    }

    @Field(index = 1, type = FieldType.FIXEDSTRING, length = 20)
    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }
	
    private String carLicense;
    private String deviceType;
}

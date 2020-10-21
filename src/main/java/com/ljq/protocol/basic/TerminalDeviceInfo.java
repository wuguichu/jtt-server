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

    @Field(index = 3, type = FieldType.UINT32STRING)
    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    @Field(index = 5, type = FieldType.UINT32STRING)
    public String getMcuVersion() {
        return mcuVersion;
    }

    public void setMcuVersion(String mcuVersion) {
        this.mcuVersion = mcuVersion;
    }

    @Field(index = 7, type = FieldType.UINT32STRING)
    public String getAiVersion() {
        return aiVersion;
    }

    public void setAiVersion(String aiVersion) {
        this.aiVersion = aiVersion;
    }

    @Override
    public String toString() {
        return "TerminalDeviceInfo{" +
                "carLicense='" + carLicense + '\'' +
                ", deviceType='" + deviceType + '\'' +
                ", appVersion='" + appVersion + '\'' +
                ", mcuVersion='" + mcuVersion + '\'' +
                ", aiVersion='" + aiVersion + '\'' +
                ", header=" + header +
                '}';
    }

    private String carLicense;
    private String deviceType;
    private String appVersion;
    private String mcuVersion;
    private String aiVersion;
}

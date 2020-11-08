package com.ljq.backstage.sql.entity;

public class DeviceInfo {
    public DeviceInfo() {
    }

    public DeviceInfo(String terminalSerialNumber, String carNumber, DeviceType deviceType, String appVersion, String mcuVersion, String aiVersion) {
        this.terminalSerialNumber = terminalSerialNumber;
        this.carNumber = carNumber;
        this.deviceType = deviceType;
        this.appVersion = appVersion;
        this.mcuVersion = mcuVersion;
        this.aiVersion = aiVersion;
    }

    public String getTerminalSerialNumber() {
        return terminalSerialNumber;
    }

    public void setTerminalSerialNumber(String terminalSerialNumber) {
        this.terminalSerialNumber = terminalSerialNumber;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public DeviceType getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(DeviceType deviceType) {
        this.deviceType = deviceType;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public String getMcuVersion() {
        return mcuVersion;
    }

    public void setMcuVersion(String mcuVersion) {
        this.mcuVersion = mcuVersion;
    }

    public String getAiVersion() {
        return aiVersion;
    }

    public void setAiVersion(String aiVersion) {
        this.aiVersion = aiVersion;
    }

    @Override
    public String toString() {
        return "DeviceInfo{" +
                "terminalSerialNumber='" + terminalSerialNumber + '\'' +
                ", carNumber='" + carNumber + '\'' +
                ", deviceType=" + deviceType +
                ", appVersion='" + appVersion + '\'' +
                ", mcuVersion='" + mcuVersion + '\'' +
                ", aiVersion='" + aiVersion + '\'' +
                '}';
    }

    private String terminalSerialNumber;
    private String carNumber;
    private DeviceType deviceType;
    private String appVersion;
    private String mcuVersion;
    private String aiVersion;
}

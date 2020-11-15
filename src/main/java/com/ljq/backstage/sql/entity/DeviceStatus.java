package com.ljq.backstage.sql.entity;

import java.util.Arrays;

public class DeviceStatus {

    public DeviceStatus() {
    }

    public DeviceStatus(String terminalSerialNumber, boolean powerOnStatus, Long time, Short timeZone, Long systemStatus, Integer ioChannelStatus, Integer speed, Short high, Integer directionAngle, Long longitude, Long latitude, Short gpsStatus, Short[] memoryType, Short[] memoryStatus, Long[] memoryTotalCapacity, String[] memorySerialNumber, Short udiskStatus, Short ummcStatus, Short[] channelStatus, Short[] recordStatus, Short wirelessNetType, Byte wirelessSignal, Short wirelessDialMode, String wirelessMac, String wirelessIp, Short wifiModule, Short wifiSignal, Short wifiFunction, Short wifiMode, Short[] peripheralType, Short[] peripheralConnection, String[] peripheralName, Short gsensorStatus, Integer terminalVoltage, Short accStatus, Short dmsAuthorization, Short adasAuthorization, Short bsdAuthorization, Short internalTemperature, Short outsideTemperature) {
        this.terminalSerialNumber = terminalSerialNumber;
        this.powerOnStatus = powerOnStatus;
        this.time = time;
        this.timeZone = timeZone;
        this.systemStatus = systemStatus;
        this.ioChannelStatus = ioChannelStatus;
        this.speed = speed;
        this.high = high;
        this.directionAngle = directionAngle;
        this.longitude = longitude;
        this.latitude = latitude;
        this.gpsStatus = gpsStatus;
        this.memoryType = memoryType;
        this.memoryStatus = memoryStatus;
        this.memoryTotalCapacity = memoryTotalCapacity;
        this.memorySerialNumber = memorySerialNumber;
        this.udiskStatus = udiskStatus;
        this.ummcStatus = ummcStatus;
        this.channelStatus = channelStatus;
        this.recordStatus = recordStatus;
        this.wirelessNetType = wirelessNetType;
        this.wirelessSignal = wirelessSignal;
        this.wirelessDialMode = wirelessDialMode;
        this.wirelessMac = wirelessMac;
        this.wirelessIp = wirelessIp;
        this.wifiModule = wifiModule;
        this.wifiSignal = wifiSignal;
        this.wifiFunction = wifiFunction;
        this.wifiMode = wifiMode;
        this.peripheralType = peripheralType;
        this.peripheralConnection = peripheralConnection;
        this.peripheralName = peripheralName;
        this.gsensorStatus = gsensorStatus;
        this.terminalVoltage = terminalVoltage;
        this.accStatus = accStatus;
        this.dmsAuthorization = dmsAuthorization;
        this.adasAuthorization = adasAuthorization;
        this.bsdAuthorization = bsdAuthorization;
        this.internalTemperature = internalTemperature;
        this.outsideTemperature = outsideTemperature;
    }

    public String getTerminalSerialNumber() {
        return terminalSerialNumber;
    }

    public void setTerminalSerialNumber(String terminalSerialNumber) {
        this.terminalSerialNumber = terminalSerialNumber;
    }

    public boolean isPowerOnStatus() {
        return powerOnStatus;
    }

    public void setPowerOnStatus(boolean powerOnStatus) {
        this.powerOnStatus = powerOnStatus;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Short getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(Short timeZone) {
        this.timeZone = timeZone;
    }

    public Long getSystemStatus() {
        return systemStatus;
    }

    public void setSystemStatus(Long systemStatus) {
        this.systemStatus = systemStatus;
    }

    public Integer getIoChannelStatus() {
        return ioChannelStatus;
    }

    public void setIoChannelStatus(Integer ioChannelStatus) {
        this.ioChannelStatus = ioChannelStatus;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public Short getHigh() {
        return high;
    }

    public void setHigh(Short high) {
        this.high = high;
    }

    public Integer getDirectionAngle() {
        return directionAngle;
    }

    public void setDirectionAngle(Integer directionAngle) {
        this.directionAngle = directionAngle;
    }

    public Long getLongitude() {
        return longitude;
    }

    public void setLongitude(Long longitude) {
        this.longitude = longitude;
    }

    public Long getLatitude() {
        return latitude;
    }

    public void setLatitude(Long latitude) {
        this.latitude = latitude;
    }

    public Short getGpsStatus() {
        return gpsStatus;
    }

    public void setGpsStatus(Short gpsStatus) {
        this.gpsStatus = gpsStatus;
    }

    public Short[] getMemoryType() {
        return memoryType;
    }

    public void setMemoryType(Short[] memoryType) {
        this.memoryType = memoryType;
    }

    public Short[] getMemoryStatus() {
        return memoryStatus;
    }

    public void setMemoryStatus(Short[] memoryStatus) {
        this.memoryStatus = memoryStatus;
    }

    public Long[] getMemoryTotalCapacity() {
        return memoryTotalCapacity;
    }

    public void setMemoryTotalCapacity(Long[] memoryTotalCapacity) {
        this.memoryTotalCapacity = memoryTotalCapacity;
    }

    public String[] getMemorySerialNumber() {
        return memorySerialNumber;
    }

    public void setMemorySerialNumber(String[] memorySerialNumber) {
        this.memorySerialNumber = memorySerialNumber;
    }

    public Short getUdiskStatus() {
        return udiskStatus;
    }

    public void setUdiskStatus(Short udiskStatus) {
        this.udiskStatus = udiskStatus;
    }

    public Short getUmmcStatus() {
        return ummcStatus;
    }

    public void setUmmcStatus(Short ummcStatus) {
        this.ummcStatus = ummcStatus;
    }

    public Short[] getChannelStatus() {
        return channelStatus;
    }

    public void setChannelStatus(Short[] channelStatus) {
        this.channelStatus = channelStatus;
    }

    public Short[] getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(Short[] recordStatus) {
        this.recordStatus = recordStatus;
    }

    public Short getWirelessNetType() {
        return wirelessNetType;
    }

    public void setWirelessNetType(Short wirelessNetType) {
        this.wirelessNetType = wirelessNetType;
    }

    public Byte getWirelessSignal() {
        return wirelessSignal;
    }

    public void setWirelessSignal(Byte wirelessSignal) {
        this.wirelessSignal = wirelessSignal;
    }

    public Short getWirelessDialMode() {
        return wirelessDialMode;
    }

    public void setWirelessDialMode(Short wirelessDialMode) {
        this.wirelessDialMode = wirelessDialMode;
    }

    public String getWirelessMac() {
        return wirelessMac;
    }

    public void setWirelessMac(String wirelessMac) {
        this.wirelessMac = wirelessMac;
    }

    public String getWirelessIp() {
        return wirelessIp;
    }

    public void setWirelessIp(String wirelessIp) {
        this.wirelessIp = wirelessIp;
    }

    public Short getWifiModule() {
        return wifiModule;
    }

    public void setWifiModule(Short wifiModule) {
        this.wifiModule = wifiModule;
    }

    public Short getWifiSignal() {
        return wifiSignal;
    }

    public void setWifiSignal(Short wifiSignal) {
        this.wifiSignal = wifiSignal;
    }

    public Short getWifiFunction() {
        return wifiFunction;
    }

    public void setWifiFunction(Short wifiFunction) {
        this.wifiFunction = wifiFunction;
    }

    public Short getWifiMode() {
        return wifiMode;
    }

    public void setWifiMode(Short wifiMode) {
        this.wifiMode = wifiMode;
    }

    public Short[] getPeripheralType() {
        return peripheralType;
    }

    public void setPeripheralType(Short[] peripheralType) {
        this.peripheralType = peripheralType;
    }

    public Short[] getPeripheralConnection() {
        return peripheralConnection;
    }

    public void setPeripheralConnection(Short[] peripheralConnection) {
        this.peripheralConnection = peripheralConnection;
    }

    public String[] getPeripheralName() {
        return peripheralName;
    }

    public void setPeripheralName(String[] peripheralName) {
        this.peripheralName = peripheralName;
    }

    public Short getGsensorStatus() {
        return gsensorStatus;
    }

    public void setGsensorStatus(Short gsensorStatus) {
        this.gsensorStatus = gsensorStatus;
    }

    public Integer getTerminalVoltage() {
        return terminalVoltage;
    }

    public void setTerminalVoltage(Integer terminalVoltage) {
        this.terminalVoltage = terminalVoltage;
    }

    public Short getAccStatus() {
        return accStatus;
    }

    public void setAccStatus(Short accStatus) {
        this.accStatus = accStatus;
    }

    public Short getDmsAuthorization() {
        return dmsAuthorization;
    }

    public void setDmsAuthorization(Short dmsAuthorization) {
        this.dmsAuthorization = dmsAuthorization;
    }

    public Short getAdasAuthorization() {
        return adasAuthorization;
    }

    public void setAdasAuthorization(Short adasAuthorization) {
        this.adasAuthorization = adasAuthorization;
    }

    public Short getBsdAuthorization() {
        return bsdAuthorization;
    }

    public void setBsdAuthorization(Short bsdAuthorization) {
        this.bsdAuthorization = bsdAuthorization;
    }

    public Short getInternalTemperature() {
        return internalTemperature;
    }

    public void setInternalTemperature(Short internalTemperature) {
        this.internalTemperature = internalTemperature;
    }

    public Short getOutsideTemperature() {
        return outsideTemperature;
    }

    public void setOutsideTemperature(Short outsideTemperature) {
        this.outsideTemperature = outsideTemperature;
    }

    @Override
    public String toString() {
        return "DeviceStatus{" +
                "terminalSerialNumber='" + terminalSerialNumber + '\'' +
                ", powerOnStatus=" + powerOnStatus +
                ", time=" + time +
                ", timeZone=" + timeZone +
                ", systemStatus=" + systemStatus +
                ", ioChannelStatus=" + ioChannelStatus +
                ", speed=" + speed +
                ", high=" + high +
                ", directionAngle=" + directionAngle +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", gpsStatus=" + gpsStatus +
                ", memoryType=" + Arrays.toString(memoryType) +
                ", memoryStatus=" + Arrays.toString(memoryStatus) +
                ", memoryTotalCapacity=" + Arrays.toString(memoryTotalCapacity) +
                ", memorySerialNumber=" + Arrays.toString(memorySerialNumber) +
                ", udiskStatus=" + udiskStatus +
                ", ummcStatus=" + ummcStatus +
                ", channelStatus=" + Arrays.toString(channelStatus) +
                ", recordStatus=" + Arrays.toString(recordStatus) +
                ", wirelessNetType=" + wirelessNetType +
                ", wirelessSignal=" + wirelessSignal +
                ", wirelessDialMode=" + wirelessDialMode +
                ", wirelessMac='" + wirelessMac + '\'' +
                ", wirelessIp='" + wirelessIp + '\'' +
                ", wifiModule=" + wifiModule +
                ", wifiSignal=" + wifiSignal +
                ", wifiFunction=" + wifiFunction +
                ", wifiMode=" + wifiMode +
                ", peripheralType=" + Arrays.toString(peripheralType) +
                ", peripheralConnection=" + Arrays.toString(peripheralConnection) +
                ", peripheralName=" + Arrays.toString(peripheralName) +
                ", gsensorStatus=" + gsensorStatus +
                ", terminalVoltage=" + terminalVoltage +
                ", accStatus=" + accStatus +
                ", dmsAuthorization=" + dmsAuthorization +
                ", adasAuthorization=" + adasAuthorization +
                ", bsdAuthorization=" + bsdAuthorization +
                ", internalTemperature=" + internalTemperature +
                ", outsideTemperature=" + outsideTemperature +
                '}';
    }

    private String terminalSerialNumber;
    private Boolean powerOnStatus;

    private Long time;
    private Short timeZone;

    private Long systemStatus;
    private Integer ioChannelStatus;
    private Integer speed;
    private Short high;
    private Integer directionAngle;
    private Long longitude;
    private Long latitude;

    private Short gpsStatus;
    private Short[] memoryType;
    private Short[] memoryStatus;
    private Long[] memoryTotalCapacity;
    private String[] memorySerialNumber;
    private Short udiskStatus;
    private Short ummcStatus;
    private Short[] channelStatus;
    private Short[] recordStatus;
    private Short wirelessNetType;
    private Byte wirelessSignal;
    private Short wirelessDialMode;
    private String wirelessMac;
    private String wirelessIp;
    private Short wifiModule;
    private Short wifiSignal;
    private Short wifiFunction;
    private Short wifiMode;
    private Short[] peripheralType;
    private Short[] peripheralConnection;
    private String[] peripheralName;
    private Short gsensorStatus;
    private Integer terminalVoltage;
    private Short accStatus;
    private Short dmsAuthorization;
    private Short adasAuthorization;
    private Short bsdAuthorization;
    private Short internalTemperature;
    private Short outsideTemperature;
}

package com.ljq.backstage.sql.entity;

import java.util.Arrays;

public class DeviceStatus {

    public DeviceStatus() {
    }

    public DeviceStatus(String terminalSerialNumber, boolean powerOnStatus, long time, short timeZone, long systemStatus, int ioChannelStatus, int speed, short high, int directionAngle, long longitude, long latitude, short gpsStatus, short[] memoryType, short[] memoryStatus, long[] memoryTotalCapacity, String[] memorySerialNumber, short udiskStatus, short ummcStatus, short[] channelStatus, short[] recordStatus, short wirelessNetType, byte wirelessSignal, short wirelessDialMode, String wirelessMac, String wirelessIp, short wifiModule, short wifiSignal, short wifiFunction, short wifiMode, short[] peripheralType, short[] peripheralConnection, String[] peripheralName, short gsensorStatus, int terminalVoltage, short accStatus, short dmsAuthorization, short adasAuthorization, short bsdAuthorization, short internalTemperature, short outsideTemperature) {
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

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public short getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(short timeZone) {
        this.timeZone = timeZone;
    }

    public long getSystemStatus() {
        return systemStatus;
    }

    public void setSystemStatus(long systemStatus) {
        this.systemStatus = systemStatus;
    }

    public int getIoChannelStatus() {
        return ioChannelStatus;
    }

    public void setIoChannelStatus(int ioChannelStatus) {
        this.ioChannelStatus = ioChannelStatus;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public short getHigh() {
        return high;
    }

    public void setHigh(short high) {
        this.high = high;
    }

    public int getDirectionAngle() {
        return directionAngle;
    }

    public void setDirectionAngle(int directionAngle) {
        this.directionAngle = directionAngle;
    }

    public long getLongitude() {
        return longitude;
    }

    public void setLongitude(long longitude) {
        this.longitude = longitude;
    }

    public long getLatitude() {
        return latitude;
    }

    public void setLatitude(long latitude) {
        this.latitude = latitude;
    }

    public short getGpsStatus() {
        return gpsStatus;
    }

    public void setGpsStatus(short gpsStatus) {
        this.gpsStatus = gpsStatus;
    }

    public short[] getMemoryType() {
        return memoryType;
    }

    public void setMemoryType(short[] memoryType) {
        this.memoryType = memoryType;
    }

    public short[] getMemoryStatus() {
        return memoryStatus;
    }

    public void setMemoryStatus(short[] memoryStatus) {
        this.memoryStatus = memoryStatus;
    }

    public long[] getMemoryTotalCapacity() {
        return memoryTotalCapacity;
    }

    public void setMemoryTotalCapacity(long[] memoryTotalCapacity) {
        this.memoryTotalCapacity = memoryTotalCapacity;
    }

    public String[] getMemorySerialNumber() {
        return memorySerialNumber;
    }

    public void setMemorySerialNumber(String[] memorySerialNumber) {
        this.memorySerialNumber = memorySerialNumber;
    }

    public short getUdiskStatus() {
        return udiskStatus;
    }

    public void setUdiskStatus(short udiskStatus) {
        this.udiskStatus = udiskStatus;
    }

    public short getUmmcStatus() {
        return ummcStatus;
    }

    public void setUmmcStatus(short ummcStatus) {
        this.ummcStatus = ummcStatus;
    }

    public short[] getChannelStatus() {
        return channelStatus;
    }

    public void setChannelStatus(short[] channelStatus) {
        this.channelStatus = channelStatus;
    }

    public short[] getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(short[] recordStatus) {
        this.recordStatus = recordStatus;
    }

    public short getWirelessNetType() {
        return wirelessNetType;
    }

    public void setWirelessNetType(short wirelessNetType) {
        this.wirelessNetType = wirelessNetType;
    }

    public byte getWirelessSignal() {
        return wirelessSignal;
    }

    public void setWirelessSignal(byte wirelessSignal) {
        this.wirelessSignal = wirelessSignal;
    }

    public short getWirelessDialMode() {
        return wirelessDialMode;
    }

    public void setWirelessDialMode(short wirelessDialMode) {
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

    public short getWifiModule() {
        return wifiModule;
    }

    public void setWifiModule(short wifiModule) {
        this.wifiModule = wifiModule;
    }

    public short getWifiSignal() {
        return wifiSignal;
    }

    public void setWifiSignal(short wifiSignal) {
        this.wifiSignal = wifiSignal;
    }

    public short getWifiFunction() {
        return wifiFunction;
    }

    public void setWifiFunction(short wifiFunction) {
        this.wifiFunction = wifiFunction;
    }

    public short getWifiMode() {
        return wifiMode;
    }

    public void setWifiMode(short wifiMode) {
        this.wifiMode = wifiMode;
    }

    public short[] getPeripheralType() {
        return peripheralType;
    }

    public void setPeripheralType(short[] peripheralType) {
        this.peripheralType = peripheralType;
    }

    public short[] getPeripheralConnection() {
        return peripheralConnection;
    }

    public void setPeripheralConnection(short[] peripheralConnection) {
        this.peripheralConnection = peripheralConnection;
    }

    public String[] getPeripheralName() {
        return peripheralName;
    }

    public void setPeripheralName(String[] peripheralName) {
        this.peripheralName = peripheralName;
    }

    public short getGsensorStatus() {
        return gsensorStatus;
    }

    public void setGsensorStatus(short gsensorStatus) {
        this.gsensorStatus = gsensorStatus;
    }

    public int getTerminalVoltage() {
        return terminalVoltage;
    }

    public void setTerminalVoltage(int terminalVoltage) {
        this.terminalVoltage = terminalVoltage;
    }

    public short getAccStatus() {
        return accStatus;
    }

    public void setAccStatus(short accStatus) {
        this.accStatus = accStatus;
    }

    public short getDmsAuthorization() {
        return dmsAuthorization;
    }

    public void setDmsAuthorization(short dmsAuthorization) {
        this.dmsAuthorization = dmsAuthorization;
    }

    public short getAdasAuthorization() {
        return adasAuthorization;
    }

    public void setAdasAuthorization(short adasAuthorization) {
        this.adasAuthorization = adasAuthorization;
    }

    public short getBsdAuthorization() {
        return bsdAuthorization;
    }

    public void setBsdAuthorization(short bsdAuthorization) {
        this.bsdAuthorization = bsdAuthorization;
    }

    public short getInternalTemperature() {
        return internalTemperature;
    }

    public void setInternalTemperature(short internalTemperature) {
        this.internalTemperature = internalTemperature;
    }

    public short getOutsideTemperature() {
        return outsideTemperature;
    }

    public void setOutsideTemperature(short outsideTemperature) {
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
    private boolean powerOnStatus;

    private long time;
    private short timeZone;

    private long systemStatus;
    private int ioChannelStatus;
    private int speed;
    private short high;
    private int directionAngle;
    private long longitude;
    private long latitude;

    private short gpsStatus;
    private short[] memoryType;
    private short[] memoryStatus;
    private long[] memoryTotalCapacity;
    private String[] memorySerialNumber;
    private short udiskStatus;
    private short ummcStatus;
    private short[] channelStatus;
    private short[] recordStatus;
    private short wirelessNetType;
    private byte wirelessSignal;
    private short wirelessDialMode;
    private String wirelessMac;
    private String wirelessIp;
    private short wifiModule;
    private short wifiSignal;
    private short wifiFunction;
    private short wifiMode;
    private short[] peripheralType;
    private short[] peripheralConnection;
    private String[] peripheralName;
    private short gsensorStatus;
    private int terminalVoltage;
    private short accStatus;
    private short dmsAuthorization;
    private short adasAuthorization;
    private short bsdAuthorization;
    private short internalTemperature;
    private short outsideTemperature;
}

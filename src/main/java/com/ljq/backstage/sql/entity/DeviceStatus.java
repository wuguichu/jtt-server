package com.ljq.backstage.sql.entity;

import java.util.Arrays;

public class DeviceStatus {

    public DeviceStatus() {
    }

    public DeviceStatus(String terminalSerialNumber, boolean powerOnStatus, long time, short timeZone, long systemStatus, int ioChannelStatus, int speed, short high, int directionAngle, long longitude, long latitude, short gpsStatus, short[] memoryType, short[] memoryStatus, long[] totalCapacity, String[] memorySerialNumber, short udiskStatus, short ummcStatus, short[] channelStatus, short[] recordStatus, short netType, byte signal, short dialMode, String mac, String ip, short module, short wifiSignal, short features, short wifiMode, short[] peripheralType, short[] connectionStat, String[] connectionName, short gsensorStatus, int terminalVoltage, short accStatus, short dmsAuthorization, short adasAuthorization, short bsdAuthorization, short insideTemperature, short outsideTemperature) {
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
        this.totalCapacity = totalCapacity;
        this.memorySerialNumber = memorySerialNumber;
        this.udiskStatus = udiskStatus;
        this.ummcStatus = ummcStatus;
        this.channelStatus = channelStatus;
        this.recordStatus = recordStatus;
        this.netType = netType;
        this.signal = signal;
        this.dialMode = dialMode;
        this.mac = mac;
        this.ip = ip;
        this.module = module;
        this.wifiSignal = wifiSignal;
        this.features = features;
        this.wifiMode = wifiMode;
        this.peripheralType = peripheralType;
        this.connectionStat = connectionStat;
        this.connectionName = connectionName;
        this.gsensorStatus = gsensorStatus;
        this.terminalVoltage = terminalVoltage;
        this.accStatus = accStatus;
        this.dmsAuthorization = dmsAuthorization;
        this.adasAuthorization = adasAuthorization;
        this.bsdAuthorization = bsdAuthorization;
        this.insideTemperature = insideTemperature;
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

    public long[] getTotalCapacity() {
        return totalCapacity;
    }

    public void setTotalCapacity(long[] totalCapacity) {
        this.totalCapacity = totalCapacity;
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

    public short getNetType() {
        return netType;
    }

    public void setNetType(short netType) {
        this.netType = netType;
    }

    public byte getSignal() {
        return signal;
    }

    public void setSignal(byte signal) {
        this.signal = signal;
    }

    public short getDialMode() {
        return dialMode;
    }

    public void setDialMode(short dialMode) {
        this.dialMode = dialMode;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public short getModule() {
        return module;
    }

    public void setModule(short module) {
        this.module = module;
    }

    public short getWifiSignal() {
        return wifiSignal;
    }

    public void setWifiSignal(short wifiSignal) {
        this.wifiSignal = wifiSignal;
    }

    public short getFeatures() {
        return features;
    }

    public void setFeatures(short features) {
        this.features = features;
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

    public short[] getConnectionStat() {
        return connectionStat;
    }

    public void setConnectionStat(short[] connectionStat) {
        this.connectionStat = connectionStat;
    }

    public String[] getConnectionName() {
        return connectionName;
    }

    public void setConnectionName(String[] connectionName) {
        this.connectionName = connectionName;
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

    public short getInsideTemperature() {
        return insideTemperature;
    }

    public void setInsideTemperature(short insideTemperature) {
        this.insideTemperature = insideTemperature;
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
                ", totalCapacity=" + Arrays.toString(totalCapacity) +
                ", memorySerialNumber=" + Arrays.toString(memorySerialNumber) +
                ", udiskStatus=" + udiskStatus +
                ", ummcStatus=" + ummcStatus +
                ", channelStatus=" + Arrays.toString(channelStatus) +
                ", recordStatus=" + Arrays.toString(recordStatus) +
                ", netType=" + netType +
                ", signal=" + signal +
                ", dialMode=" + dialMode +
                ", mac='" + mac + '\'' +
                ", ip='" + ip + '\'' +
                ", module=" + module +
                ", wifiSignal=" + wifiSignal +
                ", features=" + features +
                ", wifiMode=" + wifiMode +
                ", peripheralType=" + Arrays.toString(peripheralType) +
                ", connectionStat=" + Arrays.toString(connectionStat) +
                ", connectionName=" + Arrays.toString(connectionName) +
                ", gsensorStatus=" + gsensorStatus +
                ", terminalVoltage=" + terminalVoltage +
                ", accStatus=" + accStatus +
                ", dmsAuthorization=" + dmsAuthorization +
                ", adasAuthorization=" + adasAuthorization +
                ", bsdAuthorization=" + bsdAuthorization +
                ", insideTemperature=" + insideTemperature +
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
    private long[] totalCapacity;
    private String[] memorySerialNumber;
    private short udiskStatus;
    private short ummcStatus;
    private short[] channelStatus;
    private short[] recordStatus;
    private short netType;
    private byte signal;
    private short dialMode;
    private String mac;
    private String ip;
    private short module;
    private short wifiSignal;
    private short features;
    private short wifiMode;
    private short[] peripheralType;
    private short[] connectionStat;
    private String[] connectionName;
    private short gsensorStatus;
    private int terminalVoltage;
    private short accStatus;
    private short dmsAuthorization;
    private short adasAuthorization;
    private short bsdAuthorization;
    private short insideTemperature;
    private short outsideTemperature;
}

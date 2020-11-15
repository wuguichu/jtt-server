package com.ljq.backstage.sql.utils;

import com.ljq.backstage.sql.entity.DeviceStatus;
import com.ljq.framework.utils.BCDTransform;
import com.ljq.protocol.basic.BasicId;
import com.ljq.protocol.basic.PowerOnSelfCheckInfo;
import com.ljq.protocol.basic.TerminalStatusChange;

public final class DeviceStatusUtils {
    public static DeviceStatus getDeviceStatusByPowerOnStatus(PowerOnSelfCheckInfo terminalStatus) {
        DeviceStatus deviceStatus = new DeviceStatus();

        deviceStatus.setTerminalSerialNumber(BCDTransform.toString(terminalStatus.getHeader().getTerminalNum()));
        deviceStatus.setPowerOnStatus(terminalStatus.getHeader().getInstruction() == BasicId.POWER_ON_SELF_CHECK_INFO);
        deviceStatus.setTime(terminalStatus.getTimeInfo().getTime());
        deviceStatus.setTimeZone(terminalStatus.getTimeInfo().getTimeZone());
        deviceStatus.setSystemStatus(terminalStatus.getLocationInfo().getSystemStatus());
        deviceStatus.setSpeed(terminalStatus.getLocationInfo().getSpeed());
        deviceStatus.setHigh(terminalStatus.getLocationInfo().getHigh());
        deviceStatus.setDirectionAngle(terminalStatus.getLocationInfo().getDirectionAngle());
        deviceStatus.setLongitude(terminalStatus.getLocationInfo().getLongitude());
        deviceStatus.setLatitude(terminalStatus.getLocationInfo().getLatitude());

        if (terminalStatus.getBaseStatus().getGps() != null) {
            deviceStatus.setGpsStatus(terminalStatus.getBaseStatus().getGps().getGpsStatus());
        }
        if (terminalStatus.getBaseStatus().getStorage() != null) {
            // TODO
        }
        if (terminalStatus.getBaseStatus().getPartition() != null) {
            deviceStatus.setUdiskStatus(terminalStatus.getBaseStatus().getPartition().getUdiskStatus());
            deviceStatus.setUmmcStatus(terminalStatus.getBaseStatus().getPartition().getUmmcStatus());
        }
        if (terminalStatus.getBaseStatus().getChannel() != null) {
            // TODO
        }
        if (terminalStatus.getBaseStatus().getRecord() != null) {
            // TODO
        }
        if (terminalStatus.getBaseStatus().getWireless() != null) {
            deviceStatus.setWirelessNetType(terminalStatus.getBaseStatus().getWireless().getType());
            deviceStatus.setWirelessSignal(terminalStatus.getBaseStatus().getWireless().getSignal());
            deviceStatus.setWirelessDialMode(terminalStatus.getBaseStatus().getWireless().getMode());
            deviceStatus.setWirelessMac(terminalStatus.getBaseStatus().getWireless().getMac());
            deviceStatus.setWirelessIp(terminalStatus.getBaseStatus().getWireless().getIp());
        }
        if (terminalStatus.getBaseStatus().getWifi() != null) {
            deviceStatus.setWifiModule(terminalStatus.getBaseStatus().getWifi().getModule());
            deviceStatus.setWifiSignal(terminalStatus.getBaseStatus().getWifi().getSingle());
            deviceStatus.setWifiFunction(terminalStatus.getBaseStatus().getWifi().getFeatures());
            deviceStatus.setWifiMode(terminalStatus.getBaseStatus().getWifi().getMode());
        }
        if (terminalStatus.getBaseStatus().getPeripheral() != null) {
            // TODO
        }
        if (terminalStatus.getBaseStatus().getGsensor() != null) {
            deviceStatus.setGsensorStatus(terminalStatus.getBaseStatus().getGsensor().getGsensorStatus());
        }
        if (terminalStatus.getBaseStatus().getVoltage() != null) {
            deviceStatus.setTerminalVoltage(terminalStatus.getBaseStatus().getVoltage().getVoltageStatus());
            deviceStatus.setAccStatus(terminalStatus.getBaseStatus().getVoltage().getAccStatus());
        }
        if (terminalStatus.getBaseStatus().getAiAuthorization() != null) {
            deviceStatus.setDmsAuthorization(terminalStatus.getBaseStatus().getAiAuthorization().getDmsAuthStatus());
            deviceStatus.setAdasAuthorization(terminalStatus.getBaseStatus().getAiAuthorization().getAdasAuthStatus());
            deviceStatus.setBsdAuthorization(terminalStatus.getBaseStatus().getAiAuthorization().getBsdAuthStatus());
        }
        if (terminalStatus.getBaseStatus().getTemperature() != null) {
            deviceStatus.setInternalTemperature(terminalStatus.getBaseStatus().getTemperature().getInsideTemperature());
            deviceStatus.setOutsideTemperature(terminalStatus.getBaseStatus().getTemperature().getOutsideTemperature());
        }

        return deviceStatus;
    }

    public static DeviceStatus getDeviceStatusDiffByPowerOnStatus(PowerOnSelfCheckInfo terminalStatus, DeviceStatus deviceStatus) {
        if (!deviceStatus.getTerminalSerialNumber().equals(BCDTransform.toString(terminalStatus.getHeader().getTerminalNum())) || deviceStatus.getTime() != terminalStatus.getTimeInfo().getTime())
            return deviceStatus;

        DeviceStatus deviceStatusDiff = getDeviceStatusByPowerOnStatus(terminalStatus);
        deviceStatusDiff.setPowerOnStatus(deviceStatus.isPowerOnStatus());

        return deviceStatusDiff;
    }

    public static DeviceStatus getDeviceStatusByChangeStatus(TerminalStatusChange terminalStatus) {
        DeviceStatus deviceStatus = new DeviceStatus();

        deviceStatus.setTerminalSerialNumber(BCDTransform.toString(terminalStatus.getHeader().getTerminalNum()));
        deviceStatus.setPowerOnStatus(terminalStatus.getHeader().getInstruction() == BasicId.POWER_ON_SELF_CHECK_INFO);
        deviceStatus.setTime(terminalStatus.getTimeInfo().getTime());
        deviceStatus.setTimeZone(terminalStatus.getTimeInfo().getTimeZone());
        deviceStatus.setSystemStatus(terminalStatus.getLocationInfo().getSystemStatus());
        deviceStatus.setSpeed(terminalStatus.getLocationInfo().getSpeed());
        deviceStatus.setHigh(terminalStatus.getLocationInfo().getHigh());
        deviceStatus.setDirectionAngle(terminalStatus.getLocationInfo().getDirectionAngle());
        deviceStatus.setLongitude(terminalStatus.getLocationInfo().getLongitude());
        deviceStatus.setLatitude(terminalStatus.getLocationInfo().getLatitude());

        if (terminalStatus.getBaseStatus().getGps() != null) {
            deviceStatus.setGpsStatus(terminalStatus.getBaseStatus().getGps().getGpsStatus());
        }
        if (terminalStatus.getBaseStatus().getStorage() != null) {
            // TODO
        }
        if (terminalStatus.getBaseStatus().getPartition() != null) {
            deviceStatus.setUdiskStatus(terminalStatus.getBaseStatus().getPartition().getUdiskStatus());
            deviceStatus.setUmmcStatus(terminalStatus.getBaseStatus().getPartition().getUmmcStatus());
        }
        if (terminalStatus.getBaseStatus().getChannel() != null) {
            // TODO
        }
        if (terminalStatus.getBaseStatus().getRecord() != null) {
            // TODO
        }
        if (terminalStatus.getBaseStatus().getWireless() != null) {
            deviceStatus.setWirelessNetType(terminalStatus.getBaseStatus().getWireless().getType());
            deviceStatus.setWirelessSignal(terminalStatus.getBaseStatus().getWireless().getSignal());
            deviceStatus.setWirelessDialMode(terminalStatus.getBaseStatus().getWireless().getMode());
            deviceStatus.setWirelessMac(terminalStatus.getBaseStatus().getWireless().getMac());
            deviceStatus.setWirelessIp(terminalStatus.getBaseStatus().getWireless().getIp());
        }
        if (terminalStatus.getBaseStatus().getWifi() != null) {
            deviceStatus.setWifiModule(terminalStatus.getBaseStatus().getWifi().getModule());
            deviceStatus.setWifiSignal(terminalStatus.getBaseStatus().getWifi().getSingle());
            deviceStatus.setWifiFunction(terminalStatus.getBaseStatus().getWifi().getFeatures());
            deviceStatus.setWifiMode(terminalStatus.getBaseStatus().getWifi().getMode());
        }
        if (terminalStatus.getBaseStatus().getPeripheral() != null) {
            // TODO
        }
        if (terminalStatus.getBaseStatus().getGsensor() != null) {
            deviceStatus.setGsensorStatus(terminalStatus.getBaseStatus().getGsensor().getGsensorStatus());
        }
        if (terminalStatus.getBaseStatus().getVoltage() != null) {
            deviceStatus.setTerminalVoltage(terminalStatus.getBaseStatus().getVoltage().getVoltageStatus());
            deviceStatus.setAccStatus(terminalStatus.getBaseStatus().getVoltage().getAccStatus());
        }
        if (terminalStatus.getBaseStatus().getAiAuthorization() != null) {
            deviceStatus.setDmsAuthorization(terminalStatus.getBaseStatus().getAiAuthorization().getDmsAuthStatus());
            deviceStatus.setAdasAuthorization(terminalStatus.getBaseStatus().getAiAuthorization().getAdasAuthStatus());
            deviceStatus.setBsdAuthorization(terminalStatus.getBaseStatus().getAiAuthorization().getBsdAuthStatus());
        }
        if (terminalStatus.getBaseStatus().getTemperature() != null) {
            deviceStatus.setInternalTemperature(terminalStatus.getBaseStatus().getTemperature().getInsideTemperature());
            deviceStatus.setOutsideTemperature(terminalStatus.getBaseStatus().getTemperature().getOutsideTemperature());
        }

        return deviceStatus;
    }

    public static DeviceStatus getDeviceStatusDiffByChangeStatus(TerminalStatusChange terminalStatus, DeviceStatus deviceStatus) {
        if (!deviceStatus.getTerminalSerialNumber().equals(BCDTransform.toString(terminalStatus.getHeader().getTerminalNum())) || deviceStatus.getTime() != terminalStatus.getTimeInfo().getTime())
            return deviceStatus;

        DeviceStatus deviceStatusDiff = getDeviceStatusByChangeStatus(terminalStatus);
        deviceStatusDiff.setPowerOnStatus(deviceStatus.isPowerOnStatus());

        return deviceStatusDiff;
    }
}

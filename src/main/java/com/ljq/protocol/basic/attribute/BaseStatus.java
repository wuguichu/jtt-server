package com.ljq.protocol.basic.attribute;

public class BaseStatus {
    public BaseStatusGps getGps() {
        return gps;
    }

    public void setGps(BaseStatusGps gps) {
        this.gps = gps;
    }

    public BaseStatusStorage getStorage() {
        return storage;
    }

    public void setStorage(BaseStatusStorage storage) {
        this.storage = storage;
    }

    public BaseStatusPartition getPartition() {
        return partition;
    }

    public void setPartition(BaseStatusPartition partition) {
        this.partition = partition;
    }

    public BaseStatusChannel getChannel() {
        return channel;
    }

    public void setChannel(BaseStatusChannel channel) {
        this.channel = channel;
    }

    public BaseStatusRecord getRecord() {
        return record;
    }

    public void setRecord(BaseStatusRecord record) {
        this.record = record;
    }

    public BaseStatusWireless getWireless() {
        return wireless;
    }

    public void setWireless(BaseStatusWireless wireless) {
        this.wireless = wireless;
    }

    public BaseStatusWifi getWifi() {
        return wifi;
    }

    public void setWifi(BaseStatusWifi wifi) {
        this.wifi = wifi;
    }

    public BaseStatusPeripheral getPeripheral() {
        return peripheral;
    }

    public void setPeripheral(BaseStatusPeripheral peripheral) {
        this.peripheral = peripheral;
    }

    public BaseStatusGsensor getGsensor() {
        return gsensor;
    }

    public void setGsensor(BaseStatusGsensor gsensor) {
        this.gsensor = gsensor;
    }

    public BaseStatusVoltage getVoltage() {
        return voltage;
    }

    public void setVoltage(BaseStatusVoltage voltage) {
        this.voltage = voltage;
    }

    public BaseStatusAiAuthorization getAiAuthorization() {
        return aiAuthorization;
    }

    public void setAiAuthorization(BaseStatusAiAuthorization aiAuthorization) {
        this.aiAuthorization = aiAuthorization;
    }

    public BaseStatusTemperature getTemperature() {
        return temperature;
    }

    public void setTemperature(BaseStatusTemperature temperature) {
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return "BaseStatus{" +
                "gps=" + gps +
                ", storage=" + storage +
                ", partition=" + partition +
                ", channel=" + channel +
                ", record=" + record +
                ", wireless=" + wireless +
                ", wifi=" + wifi +
                ", peripheral=" + peripheral +
                ", gsensor=" + gsensor +
                ", voltage=" + voltage +
                ", aiAuthorization=" + aiAuthorization +
                ", temperature=" + temperature +
                '}';
    }

    private BaseStatusGps gps;
    private BaseStatusStorage storage;
    private BaseStatusPartition partition;
    private BaseStatusChannel channel;
    private BaseStatusRecord record;
    private BaseStatusWireless wireless;
    private BaseStatusWifi wifi;
    private BaseStatusPeripheral peripheral;
    private BaseStatusGsensor gsensor;
    private BaseStatusVoltage voltage;
    private BaseStatusAiAuthorization aiAuthorization;
    private BaseStatusTemperature temperature;
}
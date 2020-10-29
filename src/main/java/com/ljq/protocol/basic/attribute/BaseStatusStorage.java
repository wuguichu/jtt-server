package com.ljq.protocol.basic.attribute;

public class BaseStatusStorage {
    public short getSd1Status() {
        return sd1Status;
    }

    public void setSd1Status(short sd1Status) {
        this.sd1Status = sd1Status;
    }

    public short getSd1TotalCapacity() {
        return sd1TotalCapacity;
    }

    public void setSd1TotalCapacity(short sd1TotalCapacity) {
        this.sd1TotalCapacity = sd1TotalCapacity;
    }

    public String getSd1Serial() {
        return sd1Serial;
    }

    public void setSd1Serial(String sd1Serial) {
        this.sd1Serial = sd1Serial;
    }

    public short getSd2Status() {
        return sd2Status;
    }

    public void setSd2Status(short sd2Status) {
        this.sd2Status = sd2Status;
    }

    public short getSd2TotalCapacity() {
        return sd2TotalCapacity;
    }

    public void setSd2TotalCapacity(short sd2TotalCapacity) {
        this.sd2TotalCapacity = sd2TotalCapacity;
    }

    public String getSd2Serial() {
        return sd2Serial;
    }

    public void setSd2Serial(String sd2Serial) {
        this.sd2Serial = sd2Serial;
    }

    public short getSd3Status() {
        return sd3Status;
    }

    public void setSd3Status(short sd3Status) {
        this.sd3Status = sd3Status;
    }

    public short getSd3TotalCapacity() {
        return sd3TotalCapacity;
    }

    public void setSd3TotalCapacity(short sd3TotalCapacity) {
        this.sd3TotalCapacity = sd3TotalCapacity;
    }

    public String getSd3Serial() {
        return sd3Serial;
    }

    public void setSd3Serial(String sd3Serial) {
        this.sd3Serial = sd3Serial;
    }

    public short getSd4Status() {
        return sd4Status;
    }

    public void setSd4Status(short sd4Status) {
        this.sd4Status = sd4Status;
    }

    public short getSd4TotalCapacity() {
        return sd4TotalCapacity;
    }

    public void setSd4TotalCapacity(short sd4TotalCapacity) {
        this.sd4TotalCapacity = sd4TotalCapacity;
    }

    public String getSd4Serial() {
        return sd4Serial;
    }

    public void setSd4Serial(String sd4Serial) {
        this.sd4Serial = sd4Serial;
    }

    @Override
    public String toString() {
        return "BaseStatusStorage{" +
                "sd1Status=" + sd1Status +
                ", sd1TotalCapacity=" + sd1TotalCapacity +
                ", sd1Serial='" + sd1Serial + '\'' +
                ", sd2Status=" + sd2Status +
                ", sd2TotalCapacity=" + sd2TotalCapacity +
                ", sd2Serial='" + sd2Serial + '\'' +
                ", sd3Status=" + sd3Status +
                ", sd3TotalCapacity=" + sd3TotalCapacity +
                ", sd3Serial='" + sd3Serial + '\'' +
                ", sd4Status=" + sd4Status +
                ", sd4TotalCapacity=" + sd4TotalCapacity +
                ", sd4Serial='" + sd4Serial + '\'' +
                '}';
    }

    private short sd1Status;
    private short sd1TotalCapacity;
    private String sd1Serial;
    private short sd2Status;
    private short sd2TotalCapacity;
    private String sd2Serial;
    private short sd3Status;
    private short sd3TotalCapacity;
    private String sd3Serial;
    private short sd4Status;
    private short sd4TotalCapacity;
    private String sd4Serial;
}
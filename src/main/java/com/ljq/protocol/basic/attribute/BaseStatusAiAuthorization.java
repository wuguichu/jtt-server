package com.ljq.protocol.basic.attribute;

public class BaseStatusAiAuthorization {

    public short getDmsAuthStatus() {
        return dmsAuthStatus;
    }

    public void setDmsAuthStatus(short dmsAuthStatus) {
        this.dmsAuthStatus = dmsAuthStatus;
    }

    public short getAdasAuthStatus() {
        return adasAuthStatus;
    }

    public void setAdasAuthStatus(short adasAuthStatus) {
        this.adasAuthStatus = adasAuthStatus;
    }

    public short getBsdAuthStatus() {
        return bsdAuthStatus;
    }

    public void setBsdAuthStatus(short bsdAuthStatus) {
        this.bsdAuthStatus = bsdAuthStatus;
    }

    @Override
    public String toString() {
        return "BaseStatusAiAuthorization{" +
                "dmsAuthStatus=" + dmsAuthStatus +
                ", adasAuthStatus=" + adasAuthStatus +
                ", bsdAuthStatus=" + bsdAuthStatus +
                '}';
    }

    private short dmsAuthStatus;
    private short adasAuthStatus;
    private short bsdAuthStatus;
}
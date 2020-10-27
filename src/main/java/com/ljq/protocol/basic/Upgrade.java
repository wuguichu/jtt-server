package com.ljq.protocol.basic;

import com.ljq.framework.codec.AbstractInstruction;
import com.ljq.framework.codec.Field;
import com.ljq.framework.codec.Instruction;
import com.ljq.framework.fields.FieldType;

@Instruction(BasicId.UPGRADE)
public class Upgrade extends AbstractInstruction {
    @Field(index = 0, type = FieldType.UINT16)
    public int getFtpPort() {
        return ftpPort;
    }

    public void setFtpPort(int ftpPort) {
        this.ftpPort = ftpPort;
    }

    @Field(index = 1, type = FieldType.FIXEDSTRING, length = 64)
    public String getFtpAddress() {
        return ftpAddress;
    }

    public void setFtpAddress(String ftpAddress) {
        this.ftpAddress = ftpAddress;
    }

    @Field(index = 2, type = FieldType.FIXEDSTRING, length = 20)
    public String getFtpUserName() {
        return ftpUserName;
    }

    public void setFtpUserName(String ftpUserName) {
        this.ftpUserName = ftpUserName;
    }

    @Field(index = 3, type = FieldType.FIXEDSTRING, length = 20)
    public String getFtpPassword() {
        return ftpPassword;
    }

    public void setFtpPassword(String ftpPassword) {
        this.ftpPassword = ftpPassword;
    }

    @Field(index = 4, type = FieldType.FIXEDSTRING, length = 64)
    public String getCfgName() {
        return cfgName;
    }

    public void setCfgName(String cfgName) {
        this.cfgName = cfgName;
    }

    @Override
    public String toString() {
        return "Upgrade{" +
                "ftpPort='" + ftpPort + '\'' +
                ", ftpAddress='" + ftpAddress + '\'' +
                ", ftpUserName='" + ftpUserName + '\'' +
                ", ftpPassword='" + ftpPassword + '\'' +
                ", cfgName='" + cfgName + '\'' +
                ", header=" + header +
                '}';
    }

    private int ftpPort;
    private String ftpAddress;
    private String ftpUserName;
    private String ftpPassword;
    private String cfgName;
}

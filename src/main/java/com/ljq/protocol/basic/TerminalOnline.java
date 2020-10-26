package com.ljq.protocol.basic;

import com.ljq.framework.codec.AbstractInstruction;
import com.ljq.framework.codec.Field;
import com.ljq.framework.codec.Instruction;
import com.ljq.framework.fields.FieldType;
import com.ljq.protocol.basic.attribute.TimeInfo;

@Instruction(BasicId.TERMINAL_ONLINE)
public class TerminalOnline extends AbstractInstruction {
    @Field(index = 0, type = FieldType.FIXEDSTRING, length = 32)
    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    @Field(index = 1, type = FieldType.FIXEDSTRING, length = 32)
    public String getTerminalName() {
        return terminalName;
    }

    public void setTerminalName(String terminalName) {
        this.terminalName = terminalName;
    }

    @Field(index = 2, type = FieldType.UINT32)
    public long getTerminalType() {
        return terminalType;
    }

    public void setTerminalType(long terminalType) {
        this.terminalType = terminalType;
    }

    @Field(index = 3, type = FieldType.FIXEDSTRING, length = 32)
    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    @Field(index = 4, type = FieldType.SUBTYPE)
    public TimeInfo getTimeInfo() {
        return timeInfo;
    }

    public void setTimeInfo(TimeInfo timeInfo) {
        this.timeInfo = timeInfo;
    }

    @Override
    public String toString() {
        return "TerminalOnline{" +
                "verificationCode='" + verificationCode + '\'' +
                ", terminalName='" + terminalName + '\'' +
                ", terminalType=" + terminalType +
                ", appVersion='" + appVersion + '\'' +
                ", timeInfo=" + timeInfo +
                ", header=" + header +
                '}';
    }

    private String verificationCode;
    private String terminalName;
    private long terminalType;
    private String appVersion;
    private TimeInfo timeInfo;
}

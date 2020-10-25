package com.ljq.protocol.basic;

import com.ljq.framework.codec.AbstractInstruction;
import com.ljq.framework.codec.Field;
import com.ljq.framework.codec.Instruction;
import com.ljq.framework.fields.FieldType;

@Instruction(BasicId.TERMINAL_AUTH_RESP)
public class TerminalAuthResp extends AbstractInstruction {
    @Field(index = 0, type = FieldType.INT32)
    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    @Field(index = 1, type = FieldType.FIXEDSTRING, length = 32)
    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    @Field(index = 2, type = FieldType.FIXEDSTRING, length = 136)
    public String getLoginAddress() {
        return loginAddress;
    }

    public void setLoginAddress(String loginAddress) {
        this.loginAddress = loginAddress;
    }

    @Override
    public String toString() {
        return "TerminalAuthResp{" +
                "errorCode=" + errorCode +
                ", verificationCode='" + verificationCode + '\'' +
                ", loginAddress='" + loginAddress + '\'' +
                ", header=" + header +
                '}';
    }

    private int errorCode;
    private String verificationCode;
    private String loginAddress;
}

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

	@Field(index = 2, type = FieldType.UINT16)
    public int getIpVersion() {
        return ipVersion;
    }

    public void setIpVersion(int ipVersion) {
        this.ipVersion = ipVersion;
    }
	
	@Field(index = 3, type = FieldType.UINT16)
    public int getAddrFmt() {
        return addrFmt;
    }

    public void setAddrFmt(int addrFmt) {
        this.addrFmt = addrFmt;
    }
	
	@Field(index = 4, type = FieldType.UINT32)
    public long getPort() {
        return port;
    }

    public void setPort(long port) {
        this.port = port;
    }
	
    @Field(index = 5, type = FieldType.FIXEDSTRING, length = 128)
    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    @Override
    public String toString() {
        return "TerminalAuthResp{" +
                "errorCode=" + errorCode +
                ", verificationCode='" + verificationCode + '\'' +
                ", ipVersion='" + ipVersion + '\'' +
                ", addrFmt='" + addrFmt + '\'' +
                ", port='" + port + '\'' +
                ", ipAddress='" + ipAddress + '\'' +
                ", header=" + header +
                '}';
    }

    private int errorCode;
    private String verificationCode;
    private int ipVersion;
	private int addrFmt;
	private long port;
	private String ipAddress;
}

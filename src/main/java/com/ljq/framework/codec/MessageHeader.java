package com.ljq.framework.codec;

public class MessageHeader{
	public int getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}

	public long getPackageLen() {
		return packageLen;
	}

	public void setPackageLen(long packageLen) {
		this.packageLen = packageLen;
	}

	public long getTotalPack() {
		return totalPack;
	}

	public void setTotalPack(long totalPack) {
		this.totalPack = totalPack;
	}

	public long getCurrentPack() {
		return currentPack;
	}

	public void setCurrentPack(long currentPack) {
		this.currentPack = currentPack;
	}

	public long getInstruction() {
		return instruction;
	}

	public void setInstruction(long instruction) {
		this.instruction = instruction;
	}

	public String getTerminalNum() {
		return terminalNum;
	}

	public void setTerminalNum(String terminalNum) {
		this.terminalNum = terminalNum;
	}

	@Override
	public String toString() {
		return "MessageHeader{" +
				"serialNo=" + serialNo +
				", packageLen=" + packageLen +
				", totalPack=" + totalPack +
				", currentPack=" + currentPack +
				", instruction=" + instruction +
				", terminalNum='" + terminalNum + '\'' +
				'}';
	}

	private int serialNo;
	private long packageLen;
	private long totalPack;
	private long currentPack;
	private long instruction;
	private String terminalNum;
}

package com.ljq.framework.codec;

public class MessageHeader{
	public void setSerialNo(int serialNo){
		this.serialNo = serialNo;
	}

	public int getSerialNo(){
		return serialNo;
	}

	public void setPackageLen(long packageLen){
		this.packageLen = packageLen;
	}

	public long getPackageLen(){
		return packageLen;
	}

	public void setTotalPack(long totalPack){
		this.totalPack = totalPack;
	}

	public long getTotalPack(){
		return totalPack;
	}

	public void setCurrentPack(long currentPack){
		this.currentPack = currentPack;
	}

	public long getCurrentPack(){
		return currentPack;
	}

	public void setInstruction(long instruction){
		this.instruction = instruction;
	}

	public long getInstruction(){
		return instruction;
	}

	public void setTerminalNum(String terminalNum){
		this.terminalNum = terminalNum;
	}

	public String getTerminalNum(){
		return terminalNum;
	}
	
	@Override
	public String toString(){
		return "["+
			"serialNo:" + serialNo + 
			", packageLen:" + packageLen +
			", totalPack:" + totalPack +
			", currentPack:" + currentPack +
			", instruction:" + instruction +
			", terminalSerial:" + terminalNum +
			"]";
	}
	
	private int serialNo;
	private long packageLen;
	private long totalPack;
	private long currentPack;
	private long instruction;
	private String terminalNum;
}

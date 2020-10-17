package com.ljq.framework.utils;

public final class ByteTransform{
	public static short byte2UnsignedByte(byte[] buf, int index){
		return (short)(buf[index] & 0xff);
	}
	
	public static int byte2UnsignedShort(byte[] buf, int index){
		return (((buf[index] & 0xff) << 8) | (buf[index + 1] & 0xff));
	}

	public static long byte2Unsignedint(byte[] buf, int index){
		return ((buf[index]     & 0xff) << 24) |
               ((buf[index + 1] & 0xff) << 16) |
               ((buf[index + 2] & 0xff) <<  8) |
               ((buf[index + 3] & 0xff));
	}
}

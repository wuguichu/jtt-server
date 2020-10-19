package com.ljq.framework.utils;

public final class ByteTransform{
	public static short byte2UnsignedByte(byte[] buf, int index){
		return (short)(buf[index] & 0xff);
	}

	public static byte byte2Byte(byte[] buf, int index){
		return (byte)(buf[index] & 0xff);
	}

	public static int byte2UnsignedShort(byte[] buf, int index){
		return (((buf[index] & 0xff) << 8) | (buf[index + 1] & 0xff));
	}
	
	public static short byte2Short(byte[] buf, int index){
		return (short)(((buf[index] & 0xff) << 8) | (buf[index + 1] & 0xff));
	}
	
	public static long byte2Unsignedint(byte[] buf, int index){
		return ((buf[index]     & 0xffL) << 24) |
               ((buf[index + 1] & 0xff) << 16) |
               ((buf[index + 2] & 0xff) <<  8) |
               ((buf[index + 3] & 0xff));
	}

	public static int byte2int(byte[] buf, int index){
		return ((buf[index]     & 0xff) << 24) |
               ((buf[index + 1] & 0xff) << 16) |
               ((buf[index + 2] & 0xff) <<  8) |
               ((buf[index + 3] & 0xff));
	}

	public static long byte2Long(byte[] buf, int index){
		return ((buf[index]     & 0xff) << 56) |
               ((buf[index + 1] & 0xff) << 48) |
               ((buf[index + 2] & 0xff) << 40) |
               ((buf[index + 3] & 0xff) << 32) |
			   ((buf[index + 4] & 0xff) << 24) |
               ((buf[index + 5] & 0xff) << 16) |
               ((buf[index + 6] & 0xff) <<  8) |
               ((buf[index + 7] & 0xff));
	}

	public static byte[] unsignedByte2byteArray(short num){
		return new byte[]{(byte)(num & 0xff)};
	}
	
	public static byte[] byte2byteArray(byte num){
		return new byte[]{(byte)(num & 0xff)};
	}
	
	public static byte[] unsignedShort2byteArray(int num){
		return new byte[]{ (byte)((num & 0xff<< 8)>>8), (byte)(num & 0xff)};
	}

	public static byte[] short2byteArray(short num){
		return new byte[]{ (byte)((num & 0xff<< 8)>>8), (byte)(num & 0xff)};
	}

	public static byte[] unsignedInt2byteArray(long num){
		byte[] buf = new byte[4];
		buf[3] = (byte) (num & 0xFF);  
        buf[2] = (byte) (num >> 8 & 0xFF);  
        buf[1] = (byte) (num >> 16 & 0xFF);  
        buf[0] = (byte) (num >> 24 & 0xFF);  
		return buf;
	}
	
	public static byte[] int2byteArray(int num){
		byte[] buf = new byte[4];
		buf[3] = (byte) (num & 0xFF);  
        buf[2] = (byte) (num >> 8 & 0xFF);  
        buf[1] = (byte) (num >> 16 & 0xFF);  
        buf[0] = (byte) (num >> 24 & 0xFF);  
		return buf;
	}
	
	public static byte[] long2byteArray(long num){
		byte[] buf = new byte[8];
		buf[7] = (byte) (num & 0xFF);  
        buf[6] = (byte) (num >> 8 & 0xFF);  
        buf[5] = (byte) (num >> 16 & 0xFF);  
        buf[4] = (byte) (num >> 24 & 0xFF);
		buf[3] = (byte) (num >> 32 & 0xFF);  
        buf[2] = (byte) (num >> 40 & 0xFF);  
        buf[1] = (byte) (num >> 48 & 0xFF);  
        buf[0] = (byte) (num >> 56 & 0xFF); 
		return buf;
	}
}

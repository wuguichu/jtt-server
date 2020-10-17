package com.ljq.framework.utils;

//import java.time.LocalDate;
//import java.time.LocalDateTime;

public final class BCDTransform{
	public static String toString(byte[] bcd) {
		return new String(toChars(bcd));
	}

	public static char[] toChars(byte[] bcd) {
		char[] chars = new char[bcd.length * 2];
		for (int i = 0, j = 0; i < bcd.length; i++) {
			chars[j++] = (char) (48 + (bcd[i] >> 4 & 0xf));
			chars[j++] = (char) (48 + (bcd[i] & 0xf));
		}
		return chars;
	}

    public static byte[] from(String str) {
        return from(str.toCharArray());
    }

    public static byte[] from(char[] chars) {
        byte[] bcd = new byte[chars.length / 2];
        for (int i = 0, j = 0; i < bcd.length; i++) {
            bcd[i] = (byte) ((chars[j++] - 48 << 4) | ((chars[j++] - 48 & 0xf)));
        }
        return bcd;
    }

	/*
	public static byte[] from(LocalDateTime dateTime) {
        byte[] bcd = new byte[6];
        bcd[0] = bcd(dateTime.getYear() % 100);
        bcd[1] = bcd(dateTime.getMonthValue());
        bcd[2] = bcd(dateTime.getDayOfMonth());
        bcd[3] = bcd(dateTime.getHour());
        bcd[4] = bcd(dateTime.getMinute());
        bcd[5] = bcd(dateTime.getSecond());
        return bcd;
    }
    */

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

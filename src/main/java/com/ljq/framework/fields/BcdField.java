package com.ljq.framework.fields;

public class BcdField extends AbstractField<byte[]> {
    @Override
    public void setLength(int length) {
        this.length = length;
    }
	
	@Override
    public int getLength(){return length;}

	@Override
	public byte[] getValue(byte[] buf,int offset){
		if (buf == null || buf.length < offset + length) {
            return null;
        }
		
        byte[] buffer = new byte[length];
        System.arraycopy(buf, offset, buffer, 0, length);
        return buffer;
	}

	@Override
	public byte[] getByteArray(Object type){
		if(!(type instanceof byte[])){
            return null;
        }

		byte[] value = (byte[])type;
		byte[] buf = new byte[length];
		if(value.length > length)
			System.arraycopy(value, 0, buf, 0, length);
		else
			System.arraycopy(value, 0, buf, length - value.length, value.length);
        return buf;
	}

    private int length;
}

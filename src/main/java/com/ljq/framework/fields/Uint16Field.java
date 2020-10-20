package com.ljq.framework.fields;

import com.ljq.framework.utils.ByteTransform;

public class Uint16Field extends AbstractField<Integer> {
	@Override
    public int getLength(){return 2;}

	@Override
	public Integer getValue(byte[] buf,int offset){
		if (buf == null || buf.length < offset + 2) {
            return null;
        }
        return ByteTransform.byte2UnsignedShort(buf, offset);
	}

	@Override
	public byte[] getByteArray(Object type){
		if(!(type instanceof Integer)){
            return null;
        }
        return ByteTransform.unsignedShort2byteArray((Integer)type);
	}
}

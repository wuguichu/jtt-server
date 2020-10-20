package com.ljq.framework.fields;

import com.ljq.framework.utils.ByteTransform;

public class Int32Field extends AbstractField<Integer> {
	@Override
    public int getLength(){return 4;}

	@Override
	public Integer getValue(byte[] buf,int offset){
		if (buf == null || buf.length < offset + 4) {
            return null;
        }
        return ByteTransform.byte2int(buf, offset);
	}

	@Override
	public byte[] getByteArray(Object type){
		if(!(type instanceof Integer)){
            return null;
        }
        return ByteTransform.int2byteArray((Integer)type);
	}
}

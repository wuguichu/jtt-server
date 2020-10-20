package com.ljq.framework.fields;

import com.ljq.framework.utils.ByteTransform;

public class Uint32Field extends AbstractField<Long> {
	@Override
    public int getLength(){return 4;}

	@Override
	public Long getValue(byte[] buf,int offset){
		if (buf == null || buf.length < offset + 4) {
            return null;
        }
        return ByteTransform.byte2Unsignedint(buf, offset);
	}

	@Override
	public byte[] getByteArray(Object type){
		if(!(type instanceof Long)){
            return null;
        }
        return ByteTransform.unsignedInt2byteArray((Long)type);
	}
}

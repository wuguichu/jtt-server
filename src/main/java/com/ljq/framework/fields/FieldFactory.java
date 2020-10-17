package com.ljq.framework.fields;

public final class FieldFactory{
	public static AbstractField getFieldProduct(FieldType type){
		switch(type){
			case INT8:
				return new Int8Field();
			case FIXEDSTRING:
				return new FixedStringField();
			case BCD:
				return new BcdField();
			case REVERSE:
				return new ReserveField();
		}
		
		return null;
	}
}

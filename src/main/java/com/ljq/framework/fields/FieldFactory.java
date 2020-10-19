package com.ljq.framework.fields;

public final class FieldFactory {
    public static AbstractField<?> getFieldProduct(FieldType type) {
        return switch (type) {
            case INT8 -> new Int8Field();
			case INT16 -> new Int16Field();
			case INT32 -> new Int32Field();
			case INT64 -> new Int64Field();
			case UINT8 -> new Uint8Field();
			case UINT16 -> new Uint16Field();
			case UINT32 -> new Uint32Field();
            case FIXEDSTRING -> new FixedStringField();
            case BCD -> new BcdField();
            case RESERVE -> new ReserveField();
        };
    }
}

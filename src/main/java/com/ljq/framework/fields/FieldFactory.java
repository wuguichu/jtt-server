package com.ljq.framework.fields;

public final class FieldFactory {
    public static AbstractField<?> getFieldProduct(FieldType type) {
        return switch (type) {
            case INT8 -> new Int8Field();
            case FIXEDSTRING -> new FixedStringField();
            case BCD -> new BcdField();
            case RESERVE -> new ReserveField();
        };
    }
}

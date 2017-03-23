package com.github.ilevshevich.mapper.delimited.transform.cast;

public class ToFloat {
    public static Float cast(final Object value) throws Exception {
        if (!(value instanceof Float)) {
            throw new IllegalArgumentException("Value must have a Float type in this implementation");
        }

        return Float.class.cast(value);
    }
}

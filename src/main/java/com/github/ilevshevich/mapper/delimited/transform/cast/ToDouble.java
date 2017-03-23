package com.github.ilevshevich.mapper.delimited.transform.cast;

public class ToDouble {
    public static Double cast(final Object value) throws Exception {
        if (!(value instanceof Double)) {
            throw new IllegalArgumentException("Value must have a Double type in this implementation");
        }

        return Double.class.cast(value);
    }
}

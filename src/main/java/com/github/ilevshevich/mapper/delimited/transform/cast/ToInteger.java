package com.github.ilevshevich.mapper.delimited.transform.cast;

public class ToInteger {
    public static Integer cast(final Object value) throws Exception {
        if (!(value instanceof Integer)) {
            throw new IllegalArgumentException("Value must have a Integer type in this implementation");
        }

        return Integer.class.cast(value);
    }
}

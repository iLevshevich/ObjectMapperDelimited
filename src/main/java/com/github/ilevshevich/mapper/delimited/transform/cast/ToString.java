package com.github.ilevshevich.mapper.delimited.transform.cast;

public class ToString {
    public static String cast(final Object value) throws Exception {
        if (!(value instanceof String)) {
            throw new IllegalArgumentException("Value must have a String type in this implementation");
        }

        return String.class.cast(value);
    }
}

package com.github.ilevshevich.mapper.delimited.transform.cast;

public class ToLong {
    public static Long cast(final Object value) throws Exception {
        if (!(value instanceof Long)) {
            throw new IllegalArgumentException("Value must have a Long type in this implementation");
        }

        return Long.class.cast(value);
    }
}

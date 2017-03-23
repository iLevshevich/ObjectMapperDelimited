package com.github.ilevshevich.mapper.delimited.transform.cast;

public class ToBoolean {
    public static Boolean cast(final Object value) throws Exception {
        if (!(value instanceof Boolean)) {
            throw new IllegalArgumentException("Value must have a Boolean type in this implementation");
        }

        return Boolean.class.cast(value);
    }
}

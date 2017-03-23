package com.github.ilevshevich.mapper.delimited.transform.cast;

import java.util.Date;

public class ToDate {
    public static Date cast(final Object value) throws Exception {
        if (!(value instanceof Date)) {
            throw new IllegalArgumentException("Value must have a Date type in this implementation");
        }

        return Date.class.cast(value);
    }
}

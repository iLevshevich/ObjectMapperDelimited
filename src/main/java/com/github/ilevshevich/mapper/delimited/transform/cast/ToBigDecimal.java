package com.github.ilevshevich.mapper.delimited.transform.cast;

import java.math.BigDecimal;

public class ToBigDecimal {
    public static BigDecimal cast(final Object value) throws Exception {
        if (!(value instanceof BigDecimal)) {
            throw new IllegalArgumentException("Value must have a BigDecimal type in this implementation");
        }

        return BigDecimal.class.cast(value);
    }
}

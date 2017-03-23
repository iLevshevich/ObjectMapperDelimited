package com.github.ilevshevich.mapper.delimited.transform.cast;

import java.math.BigInteger;

public class ToBigInteger {
    public static BigInteger cast(final Object value) throws Exception {
        if (!(value instanceof BigInteger)) {
            throw new IllegalArgumentException("Value must have a BigInteger type in this implementation");
        }

        return BigInteger.class.cast(value);
    }
}

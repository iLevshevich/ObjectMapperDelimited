package com.github.ilevshevich.mapper.delimited.strategy.chain.util;

import java.lang.reflect.Field;

public class ReflectionUtil {
    public static <U>void setFieldValue(final Field field, final U tuple, final Object data) throws IllegalAccessException {
        final boolean accessible = field.isAccessible();
        {
            field.setAccessible(true);
            field.set(tuple, data);
        }
        field.setAccessible(accessible);
    }
}

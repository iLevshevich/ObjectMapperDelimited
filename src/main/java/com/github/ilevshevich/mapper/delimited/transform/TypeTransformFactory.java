package com.github.ilevshevich.mapper.delimited.transform;

import com.github.ilevshevich.mapper.delimited.transform.extra.*;

import java.util.HashMap;
import java.util.Map;

public final class TypeTransformFactory {
    private static final Map<Class<?>, TypeTransform> container = new HashMap<>();

    static {
        container.put(BigDecimalTransform.class, new BigDecimalTransform());
        container.put(BigIntegerTransform.class, new BigIntegerTransform());
        container.put(BooleanTransform.class, new BooleanTransform());
        container.put(DateTransform.class, new DateTransform());
        container.put(DoubleTransform.class, new DoubleTransform());
        container.put(FloatTransform.class, new FloatTransform());
        container.put(IntegerTransform.class, new IntegerTransform());
        container.put(LongTransform.class, new LongTransform());
        container.put(StringTransform.class, new StringTransform());
    }

    public static TypeTransform get(final Class<?> key) {
        return container.get(key);
    }
}

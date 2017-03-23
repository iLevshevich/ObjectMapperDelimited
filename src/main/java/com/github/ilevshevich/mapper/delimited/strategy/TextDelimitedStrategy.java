package com.github.ilevshevich.mapper.delimited.strategy;

import com.github.ilevshevich.mapper.delimited.annotation.misc.Delimited;
import com.github.ilevshevich.mapper.delimited.strategy.chain.extra.*;
import com.github.ilevshevich.mapper.delimited.model.DelimetedModel;
import com.github.ilevshevich.mapper.delimited.strategy.chain.DelimitedChain;
import com.github.ilevshevich.mapper.delimited.strategy.chain.FieldDelimitedChain;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

public final class TextDelimitedStrategy<T, U extends DelimetedModel> implements DelimitedStrategy<T, U> {
    private final DelimitedChain<T, U> chain =
            new BigDecimalDelimitedChain<>(
                    new BigIntegerDelimitedChain<>(
                            new BooleanDelimitedChain<>(
                                    new DateDelimitedChain<>(
                                            new DoubleDelimitedChain<>(
                                                    new FloatDelimitedChain<>(
                                                            new IntegerDelimitedChain<>(
                                                                    new LongDelimitedChain<>(
                                                                            new StringDelimitedChain<>(
                                                                                    new FieldDelimitedChain<>())))))))));

    @Override
    public U execute(final List<T> data, final Supplier<U> instance, final Class<? extends DelimetedModel> clazzModel) throws Exception {
        final U tuple = instance.get();
        {
            final List<Field> fields = Arrays.asList(clazzModel.getDeclaredFields());
            for (Field field : fields) {
                final List<Annotation> annotations = Arrays.asList(field.getAnnotations());
                final Annotation annotation = annotations.stream()
                        .filter(item -> Objects.nonNull(item.annotationType().getAnnotation(Delimited.class)))
                        .findFirst()
                        .orElse(null);

                if (Objects.nonNull(annotation)) {
                    chain.execute(annotation, field, data, tuple);
                }
            }
        }
        return tuple;
    }
}

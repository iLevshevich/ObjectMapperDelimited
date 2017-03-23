package com.github.ilevshevich.mapper.delimited.strategy.chain.extra;

import com.github.ilevshevich.mapper.delimited.annotation.extra.BooleanDelimitedField;
import com.github.ilevshevich.mapper.delimited.strategy.chain.DelimitedChain;
import com.github.ilevshevich.mapper.delimited.transform.TypeTransformFactory;
import com.github.ilevshevich.mapper.delimited.model.DelimetedModel;
import com.github.ilevshevich.mapper.delimited.strategy.chain.util.ReflectionUtil;
import com.github.ilevshevich.mapper.delimited.transform.TypeTransform;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Objects;

public class BooleanDelimitedChain<T, U extends DelimetedModel> implements DelimitedChain<T, U> {
    private DelimitedChain<T, U> next = null;

    public BooleanDelimitedChain(final DelimitedChain<T, U> next) {
        this.next = next;
    }

    public BooleanDelimitedChain() {
        this.next = null;
    }

    @Override
    public void execute(final Annotation annotation, final Field field, final List<T> data, final U tuple) throws Exception {
        if (annotation instanceof BooleanDelimitedField) {
            final BooleanDelimitedField fieldAnnotation = (BooleanDelimitedField) annotation;
            Objects.requireNonNull(fieldAnnotation);

            final Class<? extends TypeTransform> clazzTransform = fieldAnnotation.transform();
            final TypeTransform transform = TypeTransformFactory.get(clazzTransform);
            Objects.requireNonNull(transform);

            final Integer index = fieldAnnotation.index();

            final Object setData = transform.transform(data.get(index));
            {
                ReflectionUtil.setFieldValue(field, tuple, setData);
            }
        } else if (Objects.nonNull(next)) {
            next.execute(annotation, field, data, tuple);
        }
    }
}
package com.github.ilevshevich.mapper.delimited.strategy.chain;

import com.github.ilevshevich.mapper.delimited.annotation.DelimitedField;
import com.github.ilevshevich.mapper.delimited.model.DelimetedModel;
import com.github.ilevshevich.mapper.delimited.transform.TypeTransform;
import com.github.ilevshevich.mapper.delimited.transform.TypeTransformFactory;
import com.github.ilevshevich.mapper.delimited.strategy.chain.util.ReflectionUtil;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Objects;

public class FieldDelimitedChain<T, U extends DelimetedModel> implements DelimitedChain<T, U> {
    private DelimitedChain<T, U> next = null;

    public FieldDelimitedChain(final DelimitedChain<T, U> next) {
        this.next = next;
    }

    public FieldDelimitedChain() {
        this.next = null;
    }

    @Override
    public void execute(final Annotation annotation, final Field field, final List<T> data, final U tuple) throws Exception {
        if (annotation instanceof DelimitedField) {
            final DelimitedField fieldAnnotation = (DelimitedField) annotation;
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

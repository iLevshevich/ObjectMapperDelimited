package com.github.ilevshevich.mapper.delimited;

import com.github.ilevshevich.mapper.delimited.annotation.DelimitedRecord;
import com.github.ilevshevich.mapper.delimited.annotation.misc.Delimited;
import com.github.ilevshevich.mapper.delimited.builder.DelimitedBuilder;
import com.github.ilevshevich.mapper.delimited.model.DelimetedModel;
import com.github.ilevshevich.mapper.delimited.strategy.DelimitedStrategy;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Supplier;

public final class TextDelimitedObjectMapper<T extends DelimetedModel> implements DelimitedObjectMapper<String, T> {
    private final DelimitedStrategy<String, T> strategy;
    private BiFunction<String, String, List<String>> split;
    private final Supplier<T> instance;
    private final Class<? extends DelimetedModel> clazz;

    public TextDelimitedObjectMapper(final DelimitedBuilder<String, T> mapper) {
        this.strategy = mapper.getStrategy();
        this.split = mapper.getSplit();
        this.instance = mapper.getInstance();
        this.clazz = mapper.getClazz();
    }

    @Override
    public List<T> map(final List<String> data) throws Exception{
        {
            check();
        }

        final List<T> result = new LinkedList<>();
        if (Objects.nonNull(data) &&
                !data.isEmpty()) {
            final String delimiter = getDelimiter();
            Objects.requireNonNull(delimiter);

            for (String item: data){
                final List<String> splitData = split.apply(item, delimiter);
                final T model = strategy.execute(splitData, instance, clazz);
                if(Objects.nonNull(model)){
                    result.add(model);
                }
            }
        }
        return result;
    }

    private String getDelimiter(){
        final List<Annotation> annotations = Arrays.asList(clazz.getAnnotations());
        final Annotation annotation = annotations.stream()
                .filter(item -> Objects.nonNull(item.annotationType().getAnnotation(Delimited.class)))
                .findFirst()
                .orElse(null);
        Objects.requireNonNull(annotation);

        if (annotation instanceof DelimitedRecord) {
            final DelimitedRecord fullAnnotation = (DelimitedRecord) annotation;
            final String delimiter = fullAnnotation.delimiter();
            return delimiter;
        }

        return null;
    }

    private void check() {
        checkStrategy();
        checkSplit();
        checkInstance();
        checkClazz();
    }

    private void checkStrategy() {
        if (Objects.isNull(strategy)) {
            throw new IllegalArgumentException("Strategy must been not null value");
        }
    }

    private void checkSplit() {
        if (Objects.isNull(split)) {
            throw new IllegalArgumentException("Split must been not null value");
        }
    }

    private void checkInstance() {
        if (Objects.isNull(instance)) {
            throw new IllegalArgumentException("Instance must been not null value");
        }
    }

    private void checkClazz() {
        if (Objects.isNull(clazz)) {
            throw new IllegalArgumentException("Clazz must been not null value");
        }
    }
}

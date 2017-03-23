package com.github.ilevshevich.mapper.delimited.strategy.chain;

import com.github.ilevshevich.mapper.delimited.model.DelimetedModel;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.List;

public interface DelimitedChain<T, U extends DelimetedModel> {
    void execute(final Annotation annotation, final Field field, final List<T> data, final U tuple) throws Exception;
}

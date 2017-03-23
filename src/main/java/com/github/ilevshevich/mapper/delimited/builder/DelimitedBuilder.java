package com.github.ilevshevich.mapper.delimited.builder;

import com.github.ilevshevich.mapper.delimited.model.DelimetedModel;
import com.github.ilevshevich.mapper.delimited.strategy.DelimitedStrategy;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Supplier;

public interface DelimitedBuilder<T, U extends DelimetedModel> {
    DelimitedStrategy<T, U> getStrategy();
    BiFunction<T, T, List<T>> getSplit();
    Supplier<U> getInstance();
    Class<? extends DelimetedModel> getClazz();
}

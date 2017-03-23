package com.github.ilevshevich.mapper.delimited.builder;

import com.github.ilevshevich.mapper.delimited.DelimitedObjectMapper;
import com.github.ilevshevich.mapper.delimited.TextDelimitedObjectMapper;
import com.github.ilevshevich.mapper.delimited.model.DelimetedModel;
import com.github.ilevshevich.mapper.delimited.strategy.DelimitedStrategy;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Supplier;

public final class TextDelimitedBuilder<T extends DelimetedModel> implements DelimitedBuilder<String, T> {
    private DelimitedStrategy<String, T> strategy;
    private BiFunction<String, String, List<String>> split;
    private Supplier<T> instance;
    private Class<? extends DelimetedModel> clazz;

    public TextDelimitedBuilder<T> strategy(final DelimitedStrategy<String, T> strategy) {
        this.strategy = strategy;
        return this;
    }

    public TextDelimitedBuilder<T> split(final BiFunction<String, String, List<String>> split) {
        this.split = split;
        return this;
    }

    public TextDelimitedBuilder<T> instance(final Supplier<T> instance) {
        this.instance = instance;
        return this;
    }

    public TextDelimitedBuilder<T> clazz(final Class<? extends DelimetedModel> clazz) {
        this.clazz = clazz;
        return this;
    }

    public DelimitedObjectMapper<String, T> build() {
        return new TextDelimitedObjectMapper<T>(this);
    }

    @Override
    public DelimitedStrategy<String, T> getStrategy() {
        return strategy;
    }

    @Override
    public BiFunction<String, String, List<String>> getSplit() {
        return split;
    }

    @Override
    public Supplier<T> getInstance() {
        return instance;
    }

    @Override
    public Class<? extends DelimetedModel> getClazz() {
        return clazz;
    }
}

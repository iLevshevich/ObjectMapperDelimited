package com.github.ilevshevich.mapper.delimited.strategy;

import com.github.ilevshevich.mapper.delimited.model.DelimetedModel;

import java.util.List;
import java.util.function.Supplier;

public interface DelimitedStrategy<T, U extends DelimetedModel> {
    U execute(final List<T> data, final Supplier<U> instance, final Class<? extends DelimetedModel> clazzModel) throws Exception;
}

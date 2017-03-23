package com.github.ilevshevich.mapper.delimited;

import com.github.ilevshevich.mapper.delimited.model.DelimetedModel;

import java.util.List;

public interface DelimitedObjectMapper<T, R extends DelimetedModel> {
    List<R> map(final List<T> data) throws Exception;
}

package com.github.ilevshevich.mapper.delimited.transform;

public interface TypeTransform {
    Object transform(final Object value, final String... parameters) throws Exception;
}

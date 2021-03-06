package com.github.ilevshevich.mapper.delimited.transform.extra;

import com.github.ilevshevich.mapper.delimited.transform.TypeTransform;
import com.github.ilevshevich.mapper.delimited.transform.cast.ToString;

import java.util.Objects;

public class BooleanTransform implements TypeTransform {
    @Override
    public Object transform(final Object value, final String... parameters) throws Exception {
        final String data = ToString.cast(value);
        if(Objects.isNull(data) ||
                data.isEmpty()){
            return null;
        }

        final Boolean result = Boolean.valueOf(data);
        Objects.requireNonNull(result);

        return result;
    }
}

package com.github.ilevshevich.mapper.delimited.transform.extra;

import com.github.ilevshevich.mapper.delimited.transform.TypeTransform;
import com.github.ilevshevich.mapper.delimited.transform.cast.ToString;

import java.math.BigDecimal;
import java.util.Objects;

public class BigDecimalTransform implements TypeTransform {
    @Override
    public Object transform(final Object value, final String... parameters) throws Exception {
        final String data = ToString.cast(value);
        if(Objects.isNull(data) ||
                data.isEmpty()){
            return null;
        }

        final BigDecimal result = new BigDecimal(data);
        Objects.requireNonNull(result);

        if (Objects.isNull(parameters) || parameters.length == 0) {
            return result;
        }

        final Integer scale = Integer.valueOf(parameters[0]);
        Objects.requireNonNull(scale);

        final Integer mode = Integer.valueOf(parameters[1]);
        Objects.requireNonNull(mode);

        return result.setScale(scale, mode);
    }
}

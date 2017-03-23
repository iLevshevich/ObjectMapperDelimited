package com.github.ilevshevich.mapper.delimited.transform.extra;

import com.github.ilevshevich.mapper.delimited.transform.TypeTransform;
import com.github.ilevshevich.mapper.delimited.transform.cast.ToString;

import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Objects;

public class DateTransform implements TypeTransform {
    private static final String LANGUAGE = "ru";
    private static final String COUNTRY = "RU";
    private final Locale ru = new Locale(LANGUAGE, COUNTRY);
    private final SimpleDateFormat defaultDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", ru);

    @Override
    public Object transform(final Object value, final String... parameters) throws Exception {
        final String data = ToString.cast(value);
        if(Objects.isNull(data) ||
                data.isEmpty()){
            return null;
        }

        if(Objects.isNull(parameters) || parameters.length == 0){
            return defaultDateFormat.parse(data);
        }

        final String pattern = parameters[0];
        Objects.requireNonNull(pattern);

        final SimpleDateFormat dateFormat = new SimpleDateFormat(pattern, ru);
        Objects.requireNonNull(dateFormat);

        return dateFormat.parse(data);
    }
}

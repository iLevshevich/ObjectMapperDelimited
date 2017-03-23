package com.github.ilevshevich.mapper.delimited.annotation;

import com.github.ilevshevich.mapper.delimited.transform.TypeTransform;
import com.github.ilevshevich.mapper.delimited.annotation.misc.Delimited;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@Documented
@Delimited
public @interface DelimitedField {
    int index();
    Class<? extends TypeTransform> transform();
}
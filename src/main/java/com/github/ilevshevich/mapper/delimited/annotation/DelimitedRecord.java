package com.github.ilevshevich.mapper.delimited.annotation;

import com.github.ilevshevich.mapper.delimited.annotation.misc.Delimited;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
@Delimited
public @interface DelimitedRecord {
    String delimiter() default ";";
}

package com.github.ilevshevich.mapper.delimited.annotation.extra;

import com.github.ilevshevich.mapper.delimited.annotation.misc.Delimited;
import com.github.ilevshevich.mapper.delimited.transform.extra.BigIntegerTransform;
import com.github.ilevshevich.mapper.delimited.transform.TypeTransform;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Documented
@Delimited
public @interface BigIntegerDelimitedField {
	int index();
	Class<? extends TypeTransform> transform() default BigIntegerTransform.class;
}

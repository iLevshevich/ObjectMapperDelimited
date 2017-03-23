package com.github.ilevshevich.mapper.delimited.annotation.extra;

import com.github.ilevshevich.mapper.delimited.annotation.misc.Delimited;
import com.github.ilevshevich.mapper.delimited.transform.TypeTransform;
import com.github.ilevshevich.mapper.delimited.transform.extra.FloatTransform;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Documented
@Delimited
public @interface FloatDelimitedField {
	int index();
	int scale() default 2;
	int mode() default 4 /*RoundingMode.HALF_UP*/;
	Class<? extends TypeTransform> transform() default FloatTransform.class;
}

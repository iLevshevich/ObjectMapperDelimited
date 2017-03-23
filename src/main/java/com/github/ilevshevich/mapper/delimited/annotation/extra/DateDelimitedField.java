package com.github.ilevshevich.mapper.delimited.annotation.extra;

import com.github.ilevshevich.mapper.delimited.annotation.misc.Delimited;
import com.github.ilevshevich.mapper.delimited.transform.TypeTransform;
import com.github.ilevshevich.mapper.delimited.transform.extra.DateTransform;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Documented
@Delimited
public @interface DateDelimitedField {
	int index();
	String dateFormat();
	Class<? extends TypeTransform> transform() default DateTransform.class;
}

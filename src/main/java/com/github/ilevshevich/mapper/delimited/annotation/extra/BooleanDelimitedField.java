package com.github.ilevshevich.mapper.delimited.annotation.extra;

import com.github.ilevshevich.mapper.delimited.annotation.misc.Delimited;
import com.github.ilevshevich.mapper.delimited.transform.extra.BooleanTransform;
import com.github.ilevshevich.mapper.delimited.transform.TypeTransform;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Documented
@Delimited
public @interface BooleanDelimitedField {
	int index();
	Class<? extends TypeTransform> transform() default BooleanTransform.class;
}

package com.honglinktech.zbgj.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target({ElementType.METHOD,ElementType.TYPE,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface FieldMeta {
	boolean primaryKey() default true;
	String fieldName() default "";
	String dbName() default "";
	boolean allowNull() default true;
	int length() default 0;
}

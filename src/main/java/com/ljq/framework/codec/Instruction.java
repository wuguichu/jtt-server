package com.ljq.framework.codec;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Instruction{
	int value() default -1;
}

package com.server.digitalmanagementsystemforenterpriseaftersalesproblems.annotation;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {
    String module() default "";

    String description() default "";
}

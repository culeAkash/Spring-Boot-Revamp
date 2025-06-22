package spring.boot.revamp.interceptors.afterController;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyCustomAnnotation {

    // making fields for Annotations
    String key() default "defaultKeyName";
}

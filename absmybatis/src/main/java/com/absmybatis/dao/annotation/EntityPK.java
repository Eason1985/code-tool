package com.absmybatis.dao.annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface EntityPK {
    
    String Pk() ;
    
    boolean defaultColumn() default true;
    
    String tableName();
}

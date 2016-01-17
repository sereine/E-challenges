package com.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;



@Documented
@Target(value = { java.lang.annotation.ElementType.METHOD ,java.lang.annotation.ElementType.FIELD })
@Retention(value=RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EmailConstraintValidator.class)
public @interface EmailUnique {
 
     
    String message() default "SVP changez email";
     
    Class<?>[] groups() default {};
     
    Class<? extends Payload>[] payload() default {};
      
}
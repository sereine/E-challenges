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
@Constraint(validatedBy = RefExisteContrainstValidator.class)
public @interface RefExiste  {

	 String message() default "ce refference n existe pas.";
   
	    Class<?>[] groups() default {};
	     
	    Class<? extends Payload>[] payload() default {};
	
}

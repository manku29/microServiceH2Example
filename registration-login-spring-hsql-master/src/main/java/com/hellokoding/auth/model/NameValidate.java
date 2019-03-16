/**
 * 
 */
package com.hellokoding.auth.model;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.List;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * @author Ramavi
 *
 */
@Target({ElementType.TYPE,ElementType.TYPE_PARAMETER,ElementType.CONSTRUCTOR,ElementType.PARAMETER,ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
//@Repeatable(List.class)
@Documented
@Constraint( validatedBy = {NameValidator.class})

public @interface NameValidate {

	String message() default "Name Must Match with admin123456";
	Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
    
    String value();
    
    
/*    @Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE })
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @interface List {
        Age[] value();
    }
	*/
	
}

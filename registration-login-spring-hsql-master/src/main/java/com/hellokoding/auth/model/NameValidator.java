/**
 * 
 */
package com.hellokoding.auth.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Ramavi
 *
 */
public class NameValidator implements ConstraintValidator<NameValidate, String> {

    protected String name;
    
    @Override
    public void initialize(NameValidate ageValue) {
        this.name = ageValue.value();
    }
    


	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {

System.out.println(  " value :::: " + value);
System.out.println(  " name :::: " +name);
		return true;
	}

}

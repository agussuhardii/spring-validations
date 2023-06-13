package com.agussuhardi.springvalidation.costumevalidation;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

/**
 * @author agus.suhardii@gmail.com
 * @created 13/06/23/06/2023 :21.25
 * @project spring-validation
 */
@Documented
@Constraint(validatedBy = RegisterCodeConstraintsImpl.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface RegisterCodeConstraints {
    String message() default "Invalid code";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}

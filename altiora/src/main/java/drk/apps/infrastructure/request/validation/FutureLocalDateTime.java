package drk.apps.infrastructure.request.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = LocalDateTimeValidator.class)
public @interface FutureLocalDateTime {
    String message() default "La fecha y hora deben ser posteriores a la fecha y hora actual";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
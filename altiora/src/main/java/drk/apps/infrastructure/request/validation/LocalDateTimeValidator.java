package drk.apps.infrastructure.request.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDateTime;

public class LocalDateTimeValidator implements ConstraintValidator<FutureLocalDateTime, LocalDateTime> {
    @Override
    public void initialize(FutureLocalDateTime constraintAnnotation) {
    }

    @Override
    public boolean isValid(LocalDateTime value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }
        return true;
    }
}
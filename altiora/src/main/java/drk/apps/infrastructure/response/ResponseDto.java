package drk.apps.infrastructure.response;

import jakarta.validation.ConstraintViolation;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
public class ResponseDto<T> {

    public ResponseDto(T data, String message, Set<String> errorMessages) {
        if (message.equals("")) {
            this.status = 200;
            this.error = false;
        } else {
            this.status = 400;
            this.error = true;
        }
        this.message = message;
        this.data = data;
        this.errorMessages = errorMessages;
    }



    public ResponseDto(T data ,Set<? extends ConstraintViolation<?>> violations) {
        this.status = 400;
        this.error = true;
        this.message = violations.stream()
                .map(cv -> cv.getMessage())
                .collect(Collectors.joining(", "));
        this.data = data;
    }

    private String message;
    private Set<String> errorMessages;
    private int status;
    private boolean error;
    private T data;


}

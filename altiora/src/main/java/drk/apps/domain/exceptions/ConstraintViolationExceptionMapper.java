package drk.apps.domain.exceptions;


import drk.apps.infrastructure.response.ResponseDto;
import jakarta.validation.ConstraintViolationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import java.util.HashSet;
import java.util.Set;

@Provider
public class ConstraintViolationExceptionMapper implements ExceptionMapper<ConstraintViolationException> {

    @Override
    public Response toResponse(ConstraintViolationException exception) {
        // Construye un mensaje de error basado en las violaciones de las restricciones
        StringBuilder errorMessage = new StringBuilder();
        Set<String> listError = new HashSet<>();
        exception.getConstraintViolations().forEach(violation -> {
            errorMessage.append(violation.getPropertyPath().toString())
                    .append(": ")
                    .append(violation.getMessage());
            listError.add(errorMessage.toString());
            
        });

        // Devuelve una respuesta personalizada incluyendo el mensaje de error
        return Response.status(Response.Status.BAD_REQUEST)
                .entity(new ResponseDto(null,"Validation error",listError))
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
}
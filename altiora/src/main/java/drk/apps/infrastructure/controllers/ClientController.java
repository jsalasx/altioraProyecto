package drk.apps.infrastructure.controllers;

import drk.apps.application.services.ClientUseCase;
import drk.apps.infrastructure.models.Client;
import drk.apps.infrastructure.request.client.CreateClientRequest;
import drk.apps.infrastructure.response.ResponseDto;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.validation.Validator;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.hibernate.validator.cdi.internal.interceptor.MethodValidated;

import java.util.Set;

@Path("v1/clients")
@MethodValidated
public class ClientController {

        @Inject
        Validator validator;
        @Inject
        ClientUseCase useCase;
        @GET
        @Produces(MediaType.APPLICATION_JSON)
        public ResponseDto<Set<Client>> getAll() {
            return new ResponseDto<Set<Client>>(useCase.getAll(),"",null);
        }

        @POST
        @Produces(MediaType.APPLICATION_JSON)
        @Consumes(MediaType.APPLICATION_JSON)
        public ResponseDto<Client> saveClient (@Valid CreateClientRequest request) {
            Client resp = useCase.saveClient(CreateClientRequest.toEntity(request));
            return new ResponseDto<Client>(resp,"",null);
        }


}

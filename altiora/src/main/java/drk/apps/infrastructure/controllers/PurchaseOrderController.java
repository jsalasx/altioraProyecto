package drk.apps.infrastructure.controllers;

import drk.apps.application.services.PurchaseOrderUseCase;
import drk.apps.infrastructure.models.PurchaseOrder;
import drk.apps.infrastructure.request.purchaseOrder.CreatePurchaseOrderRequest;
import drk.apps.infrastructure.response.ResponseDto;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.validation.Validator;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.hibernate.validator.cdi.internal.interceptor.MethodValidated;

import java.util.Set;

@Path("v1/purchaseOrder")
@MethodValidated
public class PurchaseOrderController {

    @Inject
    Validator validator;
    @Inject
    PurchaseOrderUseCase useCase;
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ResponseDto<Set<PurchaseOrder>> getAll() {
        return new ResponseDto<Set<PurchaseOrder>>(useCase.getAll(),"",null);
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ResponseDto<PurchaseOrder> getById(
            @PathParam("id") Long id
    ) {
        return new ResponseDto<PurchaseOrder>(useCase.getOneById(id),"",null);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ResponseDto<PurchaseOrder> save (@Valid CreatePurchaseOrderRequest request) {
        PurchaseOrder resp = useCase.save(CreatePurchaseOrderRequest.toEntity(request));
        return new ResponseDto<PurchaseOrder>(resp,"",null);
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ResponseDto<PurchaseOrder> update (@PathParam("id") Long id , @Valid CreatePurchaseOrderRequest request ) {
        PurchaseOrder resp = useCase.update(id,CreatePurchaseOrderRequest.toEntity(request));
        return new ResponseDto<PurchaseOrder>(resp,"",null);
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ResponseDto<PurchaseOrder> delete (@PathParam("id") Long id ) {
        useCase.delete(id);
        return new ResponseDto<PurchaseOrder>(null,"",null);
    }

}

package drk.apps.infrastructure.request.purchaseOrder;

import drk.apps.infrastructure.models.Client;
import drk.apps.infrastructure.request.client.CreateClientRequest;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class ClientRequest {

    @Min(value = 1,message = "El id del articulo no puede estar vacio")
    public Long id;

    @NotBlank(message = "Name is mandatory and cannot be empty")
    public String name;

    @NotBlank(message = "identification is mandatory and cannot be empty")
    public String identification;

    @NotBlank(message = "address is mandatory and cannot be empty")
    public String address;

    @NotBlank(message = "telephone is mandatory and cannot be empty")
    public String telephone;

    public static Client toEntity(CreateClientRequest request) {
        return new Client(request.name, request.identification,request.address, request.telephone);
    }
}

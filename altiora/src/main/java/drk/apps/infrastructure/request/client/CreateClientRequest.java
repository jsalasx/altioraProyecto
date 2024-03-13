package drk.apps.infrastructure.request.client;

import drk.apps.infrastructure.models.Client;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreateClientRequest {

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

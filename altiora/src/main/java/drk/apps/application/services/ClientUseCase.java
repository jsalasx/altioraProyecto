package drk.apps.application.services;

import drk.apps.application.inter.ClientApplicationInterface;
import drk.apps.domain.service.ClientDomainService;
import drk.apps.infrastructure.models.Client;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.Set;

@ApplicationScoped
public class ClientUseCase implements ClientApplicationInterface {

    @Inject
    ClientDomainService service;

    @Override
    public Client saveClient(Client dataToSave) {
        return service.save(dataToSave);

    }

    @Override
    public Set<Client> getAll() {
        return service.getAll();
    }
}

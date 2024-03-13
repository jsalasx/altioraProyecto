package drk.apps.domain.service;

import drk.apps.infrastructure.db.ClientDBRepository;
import drk.apps.infrastructure.models.Client;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.Set;

@ApplicationScoped
public class ClientDomainService {

    @Inject
    ClientDBRepository dbRepository;

    public Client save(Client dataToSave) {
        return this.dbRepository.save(dataToSave);
    }

    public Set<Client> getAll() {
        return this.dbRepository.getAll();
    }

}

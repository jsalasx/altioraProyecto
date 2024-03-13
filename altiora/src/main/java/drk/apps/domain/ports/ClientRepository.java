package drk.apps.domain.ports;

import drk.apps.infrastructure.models.Client;

import java.util.List;

public interface ClientRepository {
    List<Client> getAll();

    Client findById(Long id);

    void save(Client prop);

    void update(Client prop);

    void delete(Long id);

    Long nextLoanId();
}

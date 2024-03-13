package drk.apps.infrastructure.db;

import drk.apps.infrastructure.models.Client;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.HashSet;
import java.util.Set;

@ApplicationScoped
public class ClientDBRepository implements PanacheRepository<Client> {
    @Transactional
    public Client save(Client entity) {
        persist(entity);
        return  entity;
    }

    public Set<Client> getAll() {
        Set<Client> set = new HashSet<>(listAll());
        return set;
    }
}

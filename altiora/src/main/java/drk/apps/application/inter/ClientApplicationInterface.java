package drk.apps.application.inter;

import drk.apps.infrastructure.models.Client;

import java.util.Set;

public interface ClientApplicationInterface
{
        public Client saveClient(Client dataToSave);
        public Set<Client> getAll();
}

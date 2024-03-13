package drk.apps.domain.service;

import drk.apps.infrastructure.db.PurchaseOrderDBRepository;
import drk.apps.infrastructure.models.PurchaseOrder;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.Set;

@ApplicationScoped
public class PurchaseOrderService {

    @Inject
    PurchaseOrderDBRepository dbRepository;

    public PurchaseOrder save(PurchaseOrder dataToSave) {
        return this.dbRepository.save(dataToSave);
    }

    public PurchaseOrder getOneById(Long id) {
        return this.dbRepository.getOneById(id);
    }

    public PurchaseOrder update(Long id, PurchaseOrder dataToUpdate) {
        return this.dbRepository.update(id,dataToUpdate);
    }

    public Set<PurchaseOrder> getAll() {
        return this.dbRepository.getAll();
    }

    public void delete (Long id) {
        this.dbRepository.delete(id);
    }

}

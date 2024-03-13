package drk.apps.application.services;

import drk.apps.application.inter.PurchaseOrderApplicationInterface;
import drk.apps.domain.service.PurchaseOrderService;
import drk.apps.infrastructure.models.PurchaseOrder;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.Set;
@ApplicationScoped
public class PurchaseOrderUseCase implements PurchaseOrderApplicationInterface {

    @Inject
    PurchaseOrderService service;

    @Override
    public PurchaseOrder save(PurchaseOrder dataToSave) {
        return this.service.save(dataToSave);
    }

    @Override
    public PurchaseOrder getOneById(Long id) {
        return this.service.getOneById(id);
    }

    @Override
    public PurchaseOrder update(Long id, PurchaseOrder dataToUpdate) {
        return this.service.update(id,dataToUpdate);
    }

    @Override
    public Set<PurchaseOrder> getAll() {
        return this.service.getAll();
    }

    @Override
    public void delete(Long id) {
        this.service.delete(id);
    }
}

package drk.apps.application.inter;

import drk.apps.infrastructure.models.Client;
import drk.apps.infrastructure.models.PurchaseOrder;

import java.util.Set;

public interface PurchaseOrderApplicationInterface  {

    public PurchaseOrder save(PurchaseOrder dataToSave);

    public PurchaseOrder getOneById(Long id);

    public PurchaseOrder update (Long id, PurchaseOrder dataToUpdate);

    public Set<PurchaseOrder> getAll();

    public void delete(Long id);

}

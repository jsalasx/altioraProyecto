package drk.apps.infrastructure.db;

import drk.apps.infrastructure.models.Client;
import drk.apps.infrastructure.models.PurchaseOrder;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@ApplicationScoped
public class PurchaseOrderDBRepository implements PanacheRepository<PurchaseOrder> {
    @Transactional
    public PurchaseOrder save(PurchaseOrder entity) {
        persist(entity);
        return  entity;
    }

    public PurchaseOrder getOneById(Long id) {
        return findById(id);
    }
    @Transactional
    public PurchaseOrder update(Long id, PurchaseOrder entity) {
        PurchaseOrder entidadExistente = findById(id);
        if (entidadExistente == null) {
            return null;
        }
        entidadExistente.setClient(entity.getClient());
        entidadExistente.setOrderDetail(entity.getOrderDetail());
        entidadExistente.setDescription(entity.getDescription());
        entidadExistente.setTotal(entity.getTotal());
        entidadExistente.setTaxes(entity.getTaxes());
        entidadExistente.setSubtotal(entity.getSubtotal());
        entidadExistente.setUpdatedAt(LocalDateTime.now());
        persistAndFlush(entidadExistente);
        return entidadExistente;
    }
    public Set<PurchaseOrder> getAll() {
        Set<PurchaseOrder> set = new HashSet<>(listAll());
        return set;
    }
    @Transactional
    public void delete(Long id) {
        deleteById(id);
    }
}

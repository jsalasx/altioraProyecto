package drk.apps.infrastructure.models;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class PurchaseOrder extends PanacheEntityBase {

    @Id
    @GeneratedValue
    public Long id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    public Client client;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "purchase_order_id")
    public Set<OrderDetail> orderDetail;

    public String description;

    public float total;

    public float taxes;

    public float subtotal;

    public LocalDateTime createdAt;

    public LocalDateTime updatedAt;

    public PurchaseOrder(Client client, Set<OrderDetail> orderDetail, String description, float total, float taxes, float subtotal, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.client = client;
        this.orderDetail = orderDetail;
        this.description = description;
        this.total = total;
        this.taxes = taxes;
        this.subtotal = subtotal;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}

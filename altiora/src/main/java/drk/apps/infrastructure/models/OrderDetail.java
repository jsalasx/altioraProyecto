package drk.apps.infrastructure.models;


import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class OrderDetail extends PanacheEntityBase {

    @Id
    @GeneratedValue
    public Long id;


    @Column(name = "purchase_order_id")
    public Long purchaseOrderId;

    @ManyToOne
    @JoinColumn(name = "article_id")
    public Article article;

    public float quantity;

    public float unitPrice;

    public float totalPrice;

    public OrderDetail(Long id,  Article article, float quantity, float unitPrice, float totalPrice) {
        this.id = id;
        this.article = article;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.totalPrice = totalPrice;
    }

    public OrderDetail(Article article, float quantity, float unitPrice, float totalPrice) {
        this.article = article;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.totalPrice = totalPrice;
    }
    

}

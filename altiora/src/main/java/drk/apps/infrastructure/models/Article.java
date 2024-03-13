package drk.apps.infrastructure.models;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class Article extends PanacheEntityBase {

    @Id
    @GeneratedValue
    public Long id;

    public String name;

    public float price;

    public float tax;

    public Article(String name, float price, float tax) {
        this.name = name;
        this.price = price;
        this.tax = tax;
    }

    public Article(Long id, String name, float price, float tax) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.tax = tax;
    }
}

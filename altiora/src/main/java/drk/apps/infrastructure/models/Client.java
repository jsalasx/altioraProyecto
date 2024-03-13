package drk.apps.infrastructure.models;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Builder
public class Client extends PanacheEntityBase {
    @Id
    @GeneratedValue
    public Long id;

    public String name;

    public String identification;

    public String address;

    public String telephone;

    public Client(Long id, String name, String identification,String address, String telephone) {
        this.id = id;
        this.name = name;
        this.identification = identification;
        this.address = address;
        this.telephone = telephone;

    }
    public Client(String name, String identification,String address, String telephone) {
        this.name = name;
        this.identification = identification;
        this.address = address;
        this.telephone = telephone;

    }
}

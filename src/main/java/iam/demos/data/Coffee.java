package iam.demos.data;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
// NoArgs is required for JPA
@NoArgsConstructor
@Data
public class Coffee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private float price;

    public Coffee(String name, float price) {
        this.name = name;
        this.price = price;
    }
}
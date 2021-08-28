package br.com.felipemaxplay.products.model;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "PRODUCTS")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name = "NAME", nullable = false)
    String name;

    @Column(name = "PRICE", nullable = false)
    BigDecimal price;

    @Column(name = "DESCRIPTION", nullable = false)
    String description;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public Product() {
    }

    public Product(@NonNull String name, @NonNull BigDecimal price, @NonNull String description) {
        this.name = Objects.requireNonNull(name);
        this.price = Objects.requireNonNull(price);
        this.description = Objects.requireNonNull(description);
    }

    public Product(@NonNull Long id, @NonNull String name, @NonNull BigDecimal price, @NonNull String description) {
        this.id = Objects.requireNonNull(id);
        this.name = Objects.requireNonNull(name);
        this.price = Objects.requireNonNull(price);
        this.description = Objects.requireNonNull(description);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }
}

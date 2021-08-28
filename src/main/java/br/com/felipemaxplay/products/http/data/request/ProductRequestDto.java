package br.com.felipemaxplay.products.http.data.request;

import java.math.BigDecimal;

public class ProductRequestDto {

    private String name;

    private BigDecimal price;

    private String description;

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }
}

package br.com.felipemaxplay.products.http.data.response;

import java.math.BigDecimal;

public class ProductResponseDto {

    private String name;
    private BigDecimal price;
    private String description;

    @Deprecated
    public ProductResponseDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

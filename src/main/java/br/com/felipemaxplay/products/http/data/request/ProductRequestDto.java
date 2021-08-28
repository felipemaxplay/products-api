package br.com.felipemaxplay.products.http.data.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class ProductRequestDto {

    @NotEmpty
    private String name;

    @NotNull
    private BigDecimal price;

    @NotEmpty
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

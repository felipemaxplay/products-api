package br.com.felipemaxplay.products.http;

import br.com.felipemaxplay.products.http.data.request.ProductRequestDto;
import br.com.felipemaxplay.products.model.Product;
import br.com.felipemaxplay.products.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product")
public class ProductControllerImpl implements ProductController {

    private final ProductService productService;

    public ProductControllerImpl(ProductService productService) {
        this.productService = productService;
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product create(@RequestBody ProductRequestDto dto) {
        Product product = new Product(dto.getName(), dto.getPrice(), dto.getDescription());
        return productService.create(product);
    }
}

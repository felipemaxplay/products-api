package br.com.felipemaxplay.products.http;

import br.com.felipemaxplay.products.model.Product;
import br.com.felipemaxplay.products.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/Product")
public class ProductControllerImpl implements ProductController {

    private final ProductService productService;

    public ProductControllerImpl(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Product create(@RequestBody Product product) {
        return productService.create(product);
    }
}

package br.com.felipemaxplay.products.service;

import br.com.felipemaxplay.products.model.Product;

public interface ProductService {
    Product create(Product product);

    Product read(Long id);

    Product update(Product product);

    void delete(Long id);
}

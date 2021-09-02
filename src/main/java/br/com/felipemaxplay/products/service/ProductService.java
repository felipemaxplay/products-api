package br.com.felipemaxplay.products.service;

import br.com.felipemaxplay.products.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    Product create(Product product);

    Product readOne(Long id);

    Product update(Product product);

    void delete(Long id);

    List<Product> findAll();

    Page<Product> findAllPageable(Pageable pageable);
}

package br.com.felipemaxplay.products.service;

import br.com.felipemaxplay.products.model.Product;
import br.com.felipemaxplay.products.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl  implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product create(Product product) {
        Product productPersist = productRepository.save(product);
        return productPersist;
    }

    @Override
    public Product read(Long id) {
        return null;
    }

    @Override
    public Product update(Product product) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

}

package br.com.felipemaxplay.products.service;

import br.com.felipemaxplay.products.model.Product;
import br.com.felipemaxplay.products.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.util.List;

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
    public Product readOne(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new NoResultException(String.format("Product with ID %d not found", id)));
    }

    @Override
    public Product update(Product product) {
        if(!productRepository.existsById(product.getId())) {
            throw new NoResultException(String.format("Product with ID %d not found", product.getId()));
        }
        return productRepository.save(product);
    }

    @Override
    public void delete(Long id) {
        if(!productRepository.existsById(id)) {
            throw new NoResultException(String.format("Product with ID %d not found", id));
        }
        productRepository.deleteById(id);
    }

    @Override
    public Page<Product> findAllPageable(Pageable pageable) {
        return productRepository.findAll(pageable);
    }
}

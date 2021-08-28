package br.com.felipemaxplay.products.http;

import br.com.felipemaxplay.products.http.data.request.ProductRequestDto;
import br.com.felipemaxplay.products.model.Product;
import br.com.felipemaxplay.products.service.ProductService;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
    public Product create(@Valid @RequestBody ProductRequestDto dto) {
        Product product = new Product(dto.getName(), dto.getPrice(), dto.getDescription());
        return productService.create(product);
    }

    @Override
    @GetMapping(path ="/{id}")
    public Product readOne(@PathVariable(name = "id") Long id) {
        return productService.readOne(id);
    }

    @Override
    @PatchMapping("/{id}")
    public Product update(@PathVariable(name = "id") Long id, @RequestBody JsonPatch patch) throws JsonPatchException, JsonProcessingException {
        Product product = productService.readOne(id);

        ObjectMapper objectMapper = new ObjectMapper()
                .disable(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS)
                .enable(JsonGenerator.Feature.WRITE_BIGDECIMAL_AS_PLAIN)
                .setNodeFactory(JsonNodeFactory.withExactBigDecimals(true));;

        JsonNode productJsonNode = objectMapper.convertValue(product, JsonNode.class);
        JsonNode patchJsonNode = patch.apply(productJsonNode);
        Product productPersist = objectMapper.treeToValue(patchJsonNode, Product.class);

        return productService.create(productPersist);
    }

    @Override
    @PutMapping("/{id}")
    public Product updateAll(@PathVariable(name = "id") Long id, @RequestBody ProductRequestDto dto) {
        Product product = new Product(id, dto.getName(), dto.getPrice(), dto.getDescription());
        return productService.update(product);
    }

    @Override
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        productService.delete(id);
    }

}

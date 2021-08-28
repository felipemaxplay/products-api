package br.com.felipemaxplay.products.http.data.serialization;

import br.com.felipemaxplay.products.http.data.response.ProductResponseDto;
import br.com.felipemaxplay.products.model.Product;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.modelmapper.ModelMapper;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;

@JsonComponent
public class ProductSerialization extends JsonSerializer<Product> {

    private final ModelMapper modelMapper;

    public ProductSerialization(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public void serialize(Product product, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        ProductResponseDto productResponseDto = modelMapper.map(product, ProductResponseDto.class);
        jsonGenerator.writeObject(productResponseDto);
    }
}

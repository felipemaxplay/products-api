package br.com.felipemaxplay.products.http;

import br.com.felipemaxplay.products.http.data.request.ProductRequestDto;
import br.com.felipemaxplay.products.model.Product;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

public interface ProductController {

    @Operation(summary = "Create a product with all parameters passed")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Product create(@Valid @RequestBody ProductRequestDto dto);

    @Operation(summary = "Returns the product corresponding to the ID retrieved by parameter")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "404",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = "{\n" +
                                            "    \"code\": \"P_404\",\n" +
                                            "    \"message\": \"Product with ID 65 not found\",\n" +
                                            "    \"documentation\": \"\"\n" +
                                            "}"
                            )
                    )
            )
    })
    @GetMapping(path ="/{id}")
    Product readOne(@PathVariable(name = "id") Long id);

    @PatchMapping("/{id}")
    Product update(@PathVariable(name = "id") Long id, @RequestBody JsonPatch patch) throws JsonPatchException, JsonProcessingException;

    @PutMapping("/{id}")
    Product updateAll(@PathVariable(name = "id") Long id, @RequestBody ProductRequestDto dto);

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable("id") Long id);
}

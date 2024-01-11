package com.cupidconnect.controllers;

import com.cupidconnect.dtos.ProductDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${api.prefix}/products")
public class ProductController {
    @GetMapping("")
    public ResponseEntity<String> getAllProducts(
            @RequestParam("page") int page,
            @RequestParam("limit") int limit
    )
    {
        return ResponseEntity.ok("page " + page + " limit: " + limit);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getProductById(
            @PathVariable("id") String productId
    ){
        return ResponseEntity.ok("get product by id " + productId);
    }

    @PostMapping()
    public ResponseEntity<?> createProduct(
            @Valid @RequestBody ProductDTO productDTO,
            BindingResult result
            ){
        if(result.hasErrors()){
            List<String> errorMessages = result.getFieldErrors()
                    .stream()
                    .map(FieldError::getDefaultMessage)
                    .toList();
            return ResponseEntity.badRequest().body(errorMessages);
        }
        return ResponseEntity.ok("" + productDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(
           @PathVariable("id") long id
    ){
        return ResponseEntity.ok(String.format("Product with id = %d deleted successfully",id));
    }
}

package com.example.introduction.controller;

import com.example.introduction.handler.ProductNotfoundException;
import com.example.introduction.model.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
public class ProductServiceController {

    private static final Map<String, Product> productRepo = new HashMap<>();

    static {
        Product honey = new Product();
        honey.setId("1");
        honey.setName("Honey");
        productRepo.put(honey.getId(), honey);

        Product almond = new Product();
        almond.setId("2");
        almond.setName("Almond");
        productRepo.put(almond.getId(), almond);
    }

    @DeleteMapping(value = "/products/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") String id) {
        productRepo.remove(id);
        log.info("Delete response....");
        return new ResponseEntity<>("Product is deleted successfully", HttpStatus.OK);
    }

    @PutMapping(value = "/products/{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable("id") String id, @RequestBody Product product) {

        if(!productRepo.containsKey(id))
            throw new ProductNotfoundException();

        productRepo.remove(id);
        product.setId(id);
        productRepo.put(id, product);
        log.info("Put response....");
        return new ResponseEntity<>("Product is updated successfully", HttpStatus.OK);
    }

    @PostMapping(value = "/products")
    public ResponseEntity<Object> createProduct(@RequestBody Product product) {
        productRepo.put(product.getId(), product);
        log.info("Post response....");
        return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
    }

    @GetMapping(value = "/products")
    public ResponseEntity<Object> getProduct() {
        log.info("Get response....");
        return new ResponseEntity<>(productRepo.values(), HttpStatus.OK);
    }
}

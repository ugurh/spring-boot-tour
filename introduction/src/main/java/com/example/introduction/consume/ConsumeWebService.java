package com.example.introduction.consume;

import com.example.introduction.model.Product;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class ConsumeWebService {

    private final RestTemplate restTemplate;

    public ConsumeWebService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    @GetMapping(value = "/template/products")
    public String getProductList() {
        HttpHeaders headers = new HttpHeaders();
        List<MediaType> list = new ArrayList<>();
        list.add(MediaType.APPLICATION_JSON);
        headers.setAccept(list);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        return restTemplate.exchange(
                "http://localhost:8080/products", HttpMethod.GET, entity, String.class)
                .getBody();
    }

    @PostMapping(value = "/template/products")
    public String createProducts(@RequestBody Product product) {
        HttpHeaders headers = new HttpHeaders();
        List<MediaType> list = new ArrayList<>();
        list.add(MediaType.APPLICATION_JSON);
        headers.setAccept(list);
        HttpEntity<Product> entity = new HttpEntity<>(product, headers);

        return restTemplate.exchange(
                "http://localhost:8080/products", HttpMethod.POST, entity, String.class)
                .getBody();
    }

    @PutMapping(value = "/template/products/{id}")
    public String updateProduct(@PathVariable("id") String id, @RequestBody Product product) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        List<MediaType> list = new ArrayList<>();
        list.add(MediaType.APPLICATION_JSON);
        headers.setAccept(list);
        HttpEntity<Product> entity = new HttpEntity<>(product, headers);

        return restTemplate.exchange(
                "http://localhost:8080/products/"+id, HttpMethod.PUT, entity, String.class).getBody();
    }

    @DeleteMapping("/template/products/{id}")
    public String deleteProduct(@PathVariable("id") String id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Product> entity = new HttpEntity<>(headers);

        return restTemplate.exchange(
                "http://localhost:8080/products/"+id, HttpMethod.DELETE, entity, String.class).getBody();
    }

}

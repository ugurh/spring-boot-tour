package io.hrnugr.api;

import io.hrnugr.entity.Customer;
import io.hrnugr.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Customer> create(@RequestBody Customer customer){
        Customer result = customerRepository.save(customer);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable Long id){
        Customer result = customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


}

package io.hrnugr.repository;

import io.hrnugr.entity.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    Customer findByExternalId(String externalId);
    List<Customer> findByAddressesId(Long id);

}
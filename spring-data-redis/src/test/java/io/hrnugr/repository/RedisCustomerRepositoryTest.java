package io.hrnugr.repository;

import io.hrnugr.entity.Address;
import io.hrnugr.entity.Customer;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.redis.DataRedisTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataRedisTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RedisCustomerRepositoryTest {

    @Autowired
    CustomerRepository repository;

    @Test
    public void testAdd() {
        Customer customer = new Customer(1L, "68948948", "Harun UĞUR");
        customer.addAddress(new Address(1L));
        customer.addAddress(new Address(2L));
        customer.addAddress(new Address(3L));
        customer = repository.save(customer);
        Assert.assertNotNull(customer);
    }

    @Test
    public void testFindByAddress() {
        List<Customer> customers = repository.findByAddressesId(1L);
        Assert.assertEquals(1, customers.size());
        Customer customer = customers.get(0);
        Assert.assertNotNull(customer);
        Assert.assertEquals(1, customer.getId().longValue());
    }

    @Test
    public void testFindByExternal() {
        Customer customer = repository.findByExternalId("68948948");
        Assert.assertNotNull(customer);
        Assert.assertEquals(1, customer.getId().longValue());
    }

}

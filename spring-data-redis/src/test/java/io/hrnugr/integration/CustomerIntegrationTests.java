package io.hrnugr.integration;

import io.hrnugr.entity.Address;
import io.hrnugr.entity.Customer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class CustomerIntegrationTests {

    @Autowired
    TestRestTemplate template;

    @Before
    public void init() {
    }

    @Test
    public void testCreateAndFind() {
        Customer customer = new Customer(1L, "123456", "Harun UĞUR");
        customer.addAddress(new Address(1L));
        customer.addAddress(new Address(2L));
        customer = template.postForObject("/customers/create", customer, Customer.class);
        Assert.assertNotNull(customer);
        customer = template.getForObject("/customers/{id}", Customer.class, 1L);
        Assert.assertNotNull(customer);
        Assert.assertEquals("123456", customer.getExternalId());
        //Assert.assertEquals(0, customer.getAddresses().size());
    }
}

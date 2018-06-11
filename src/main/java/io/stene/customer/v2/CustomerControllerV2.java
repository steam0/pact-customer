package io.stene.customer.v2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v2/customer")
public class CustomerControllerV2 {

    @Autowired
    CustomerRepositoryV2 customerRepositoryV2;

    @GetMapping(path = "/{ssn}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Customer getCustomer(@PathVariable("ssn") String ssn) {
        return customerRepositoryV2.get(ssn);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Customer createCustomer(@RequestBody Customer customer) {
        customerRepositoryV2.add(customer);
        return customer;
    }
}

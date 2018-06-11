package io.stene.customer;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class CustomerRepository {

    private static int ID_COUNTER = 1;

    Map<Integer, Customer> map = new HashMap<>();

    public Customer add(Customer customer) {
        customer.setId(ID_COUNTER++);
        return map.put(customer.getId(), customer);
    }

    public Customer get(Integer id) {
        return map.get(id);
    }

    public Customer get(String ssn) {
        return map.values().stream()
                .filter(person -> person.getSocialSecurityNumber().equals(ssn))
                .findFirst().orElse(null);
    }
}

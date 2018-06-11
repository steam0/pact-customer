package io.stene.customer;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Customer {
    Integer id;
    String ssn;
    String name;
    String address;
}

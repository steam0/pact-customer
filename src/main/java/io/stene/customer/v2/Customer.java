package io.stene.customer.v2;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Customer {
    Integer id;
    String socialSecurityNumber;
    String name;
    Address address;
}

package io.stene.customer;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Customer {
    private Integer id;
    private String ssn;
    private String name;
    private String address;
}

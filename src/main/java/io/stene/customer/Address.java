package io.stene.customer;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Address {
    private String streetName;
    private String zipCode;
}

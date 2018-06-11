package io.stene.customer;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Customer {
    Integer id;
    @JsonProperty("ssn")
    String socialSecurityNumber;
    String name;
    Address address;
}

package io.stene.customer;

import au.com.dius.pact.provider.junit.IgnoreNoPactsToVerify;
import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.State;
import au.com.dius.pact.provider.junit.loader.PactBroker;
import au.com.dius.pact.provider.junit.target.Target;
import au.com.dius.pact.provider.junit.target.TestTarget;
import au.com.dius.pact.provider.spring.SpringRestPactRunner;
import au.com.dius.pact.provider.spring.target.SpringBootHttpTarget;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Provider("customer")
@IgnoreNoPactsToVerify
@PactBroker(host = "localhost", port = "3000")
@RunWith(SpringRestPactRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ContractVerificationTest {

    @Autowired
    CustomerRepository customerRepository;

    @TestTarget
    public final Target target = new SpringBootHttpTarget();

    @State({"default", "extra"})
    public void toDefaultState() {
        System.out.println("Now service in default state");
    }

    @State("Customer with ssn(71039012345) exists.")
    public void getCustomerPactTest() {
        customerRepository.add(Customer.builder().name("Roger Antonsen").ssn("71039012345").address("Some Blvd").build());
    }
}

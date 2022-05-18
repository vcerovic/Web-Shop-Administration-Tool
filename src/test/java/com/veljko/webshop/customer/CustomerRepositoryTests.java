package com.veljko.webshop.customer;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@Rollback()
public class CustomerRepositoryTests {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerRepositoryTests(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @BeforeEach
    void setUp() {
        Customer customer1 = new Customer(
                "Veljko",
                "veljko@gmail.com",
                "Nist", 5, 89000);

        Customer customer2 = new Customer(
                "Marko",
                "Marko@gmail.com",
                "Nist", 4, 54000);

        Customer customer3 = new Customer(
                "Aleksa",
                "Aleksa@gmail.com",
                "Nist", 8, 12000);


        customerRepository.save(customer1);
        customerRepository.save(customer2);
        customerRepository.save(customer3);
    }

    @AfterEach
    void tearDown() {
        customerRepository.deleteAll();
    }


    @Test
    void testFindCustomerWithMostMoneySpent() {
        Customer customerWithMostMoneySpent = customerRepository.findTopByOrderBySpentDesc().get();


        Assertions.assertThat(customerWithMostMoneySpent).isNotNull();
        Assertions.assertThat(customerWithMostMoneySpent.getSpent()).isEqualTo(89000);
        Assertions.assertThat(customerWithMostMoneySpent.getName()).isEqualTo("Veljko");
    }

    @Test
    void testFindCustomerWithMostPurchases() {
        Customer customerWithMostPurchases = customerRepository.findTopByOrderByPurchasesDesc().get();

        Assertions.assertThat(customerWithMostPurchases).isNotNull();
        Assertions.assertThat(customerWithMostPurchases.getPurchases()).isEqualTo(8);
        Assertions.assertThat(customerWithMostPurchases.getName()).isEqualTo("Aleksa");
    }

    @Test
    void testFindByEmail() {
        Customer customer = customerRepository.findByEmail("veljko@gmail.com").get();

        Assertions.assertThat(customer.getEmail()).isEqualTo("veljko@gmail.com");
    }

}

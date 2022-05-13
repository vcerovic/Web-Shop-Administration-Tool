package com.veljko.webshop;

import com.veljko.webshop.customer.Customer;
import com.veljko.webshop.customer.CustomerRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@Rollback()
public class CustomerRepositoryTests {

    @Autowired
    private CustomerRepository repository;

    @BeforeEach
    void destoryAll(){
        repository.deleteAll();
    }


    @Test
    void testFindCustomerWithMostMoneySpent(){
        Customer customer1 = new Customer(
                "Veljko",
                "veljko@gmail.com",
                "Nis", 5, 89000);

        Customer customer2 = new Customer(
                "Marko",
                "Marko@gmail.com",
                "Nis", 4, 54000);

        Customer customer3 = new Customer(
                "Aleksa",
                "Aleksa@gmail.com",
                "Nis", 8, 12000);


        repository.save(customer1);
        repository.save(customer2);
        repository.save(customer3);

        Customer customerWithMostMoneySpent = repository.findCustomerWithMostMoneySpent();


        Assertions.assertThat(customerWithMostMoneySpent).isNotNull();
        Assertions.assertThat(customerWithMostMoneySpent.getSpent()).isEqualTo(89000);
        Assertions.assertThat(customerWithMostMoneySpent.getName()).isEqualTo("Veljko");
    }

    @Test
    void testFindCustomerWithMostPurchases(){
        Customer customer1 = new Customer(
                "Veljko",
                "veljko@gmail.com",
                "Nis", 5, 89000);

        Customer customer2 = new Customer(
                "Marko",
                "Marko@gmail.com",
                "Nis", 4, 54000);

        Customer customer3 = new Customer(
                "Aleksa",
                "Aleksa@gmail.com",
                "Nis", 8, 12000);

        repository.save(customer1);
        repository.save(customer2);
        repository.save(customer3);

        Customer customerWithMostPurchases = repository.findCustomerWithMostPurchases();

        Assertions.assertThat(customerWithMostPurchases).isNotNull();
        Assertions.assertThat(customerWithMostPurchases.getPurchases()).isEqualTo(8);
        Assertions.assertThat(customerWithMostPurchases.getName()).isEqualTo("Aleksa");
    }


    @Test
    void testFindCustomerWithMostMoneySpentIfNull(){
        Customer customerWithMostMoneySpent = repository.findCustomerWithMostMoneySpent();
        Assertions.assertThat(customerWithMostMoneySpent).isNull();
    }

    @Test
    void testFindCustomerWithMostPurchasesIfNull(){
        Customer customerWithMostPurchases = repository.findCustomerWithMostPurchases();
        Assertions.assertThat(customerWithMostPurchases).isNull();
    }
}

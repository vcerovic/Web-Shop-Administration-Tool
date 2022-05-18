package com.veljko.webshop.sale;

import com.veljko.webshop.customer.Customer;
import com.veljko.webshop.customer.CustomerRepository;
import com.veljko.webshop.product.Product;
import com.veljko.webshop.product.ProductRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.LinkedHashSet;
import java.util.Set;

@DataJpaTest
@Rollback()
public class SaleServiceTests {

    private final ProductRepository productRepository;
    private final CustomerRepository customerRepository;

    @Autowired
    public SaleServiceTests(ProductRepository productRepository, CustomerRepository customerRepository) {
        this.productRepository = productRepository;
        this.customerRepository = customerRepository;
    }


    @AfterEach
    void tearDown() {
        productRepository.deleteAll();
        customerRepository.deleteAll();
    }

    @Test
    void testAddNewSale() {
        Product product = new Product(
                "Yugo",
                "Test, test, test, test, test",
                5,
                28000,
                "slika1.jpg",
                20);

        Customer customer = new Customer(
                "Veljko",
                "veljko@gmail.com",
                "Nist", 5, 89000);

        Customer customer2 = new Customer(
                "Marko",
                "Marko@gmail.com",
                "Nist", 4, 54000);


        Set<Customer> customers = new LinkedHashSet<>();
        customers.add(customer);
        customers.add(customer2);

        Set<Product> products = new LinkedHashSet<>();
        products.add(product);

        product.setCustomers(customers);
        customer.setProducts(products);
        customer2.setProducts(products);

        Product savedProduct = productRepository.save(product);
        Set<Customer> savedProductCustomers = savedProduct.getCustomers();

        Customer firstCustomer = savedProductCustomers.iterator().next();

        Assertions.assertThat(firstCustomer).isNotNull();
        Assertions.assertThat(firstCustomer.getPurchases()).isEqualTo(5);
        Assertions.assertThat(firstCustomer.getName()).isEqualTo("Veljko");
    }
}

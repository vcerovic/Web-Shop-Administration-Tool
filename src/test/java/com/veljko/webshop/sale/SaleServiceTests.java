package com.veljko.webshop.sale;

import com.veljko.webshop.customer.Customer;
import com.veljko.webshop.customer.CustomerRepository;
import com.veljko.webshop.product.Product;
import com.veljko.webshop.product.ProductRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

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


    }
}

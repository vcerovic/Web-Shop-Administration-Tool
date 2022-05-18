package com.veljko.webshop.product;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;


@DataJpaTest
@Rollback()
public class ProductRepositoryTests {

    private final ProductRepository productRepository;

    @Autowired
    public ProductRepositoryTests(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @BeforeEach
    void setUp() {
        Product product = new Product(
                "Yugo",
                "Test, test, test, test, test",
                5,
                28000,
                "slika1.jpg",
                20);

        Product product2 = new Product(
                "BMW - car",
                "Test, test, test, test, test",
                15,
                80000,
                "slika2.jpg",
                15);

        Product product3 = new Product(
                "Audi",
                "Test, test, test, test, test",
                20,
                78000,
                "slika3.jpg",
                5);

        productRepository.save(product);
        productRepository.save(product2);
        productRepository.save(product3);
    }

    @AfterEach
    void tearDown() {
        productRepository.deleteAll();
    }


    @Test
    void testFindMostExpensiveProduct() {
        Product mostExpensiveProduct = productRepository.findTopByOrderByPriceDesc().get();

        Assertions.assertThat(mostExpensiveProduct).isNotNull();
        Assertions.assertThat(mostExpensiveProduct.getPrice()).isEqualTo(80000);
    }


    @Test
    void testFindMostSoldProduct() {
        Product mostSoldProduct = productRepository.findTopByOrderByTimesSoldDesc().get();

        Assertions.assertThat(mostSoldProduct).isNotNull();
        Assertions.assertThat(mostSoldProduct.getTimesSold()).isEqualTo(20);
    }

    @Test
    void testFindMostStockProduct() {
        Product mostSoldProduct = productRepository.findTopByOrderByStockDesc().get();

        Assertions.assertThat(mostSoldProduct).isNotNull();
        Assertions.assertThat(mostSoldProduct.getStock()).isEqualTo(20);
    }
}

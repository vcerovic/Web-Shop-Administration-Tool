package com.veljko.webshop;

import com.veljko.webshop.product.Product;
import com.veljko.webshop.product.ProductRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;


@DataJpaTest
@Rollback()
public class ProductRepositoryTests {

    @Autowired
    private ProductRepository repository;


    @Test
    public void testFindMostExpensiveProduct() {
        Product product = new Product(
                "Yugo",
                "Test",
                5,
                28000,
                "slika1.jpg",
                5);

        Product product2 = new Product(
                "BMW",
                "Test",
                20,
                80000,
                "slika2.jpg",
                5);

        Product product3 = new Product(
                "Audi",
                "Test",
                20,
                78000,
                "slika3.jpg",
                5);

        repository.save(product);
        repository.save(product2);
        repository.save(product3);

        Product mostExpensiveProduct = repository.findMostExpensiveProduct();

        Assertions.assertThat(mostExpensiveProduct).isNotNull();
        Assertions.assertThat(mostExpensiveProduct.getName()).isEqualTo("BMW");
        Assertions.assertThat(mostExpensiveProduct.getPrice()).isEqualTo(80000);
    }


    @Test
    public void testFindMostSoldProduct() {
        Product product = new Product(
                "Yugo",
                "Test",
                5,
                28000,
                "slika1.jpg",
                56);

        Product product2 = new Product(
                "BMW",
                "Test",
                20,
                80000,
                "slika2.jpg",
                20);

        Product product3 = new Product(
                "Audi",
                "Test",
                20,
                78000,
                "slika3.jpg",
                5);


        repository.save(product);
        repository.save(product2);
        repository.save(product3);

        Product mostSoldProduct = repository.findMostSoldProduct();

        Assertions.assertThat(mostSoldProduct).isNotNull();
        Assertions.assertThat(mostSoldProduct.getName()).isEqualTo("Yugo");
        Assertions.assertThat(mostSoldProduct.getTimesSold()).isEqualTo(56);
    }
}

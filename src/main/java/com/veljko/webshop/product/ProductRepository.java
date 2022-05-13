package com.veljko.webshop.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("from Product as p where p.price = (select max(pr.price) from Product pr)")
    Product findMostExpensiveProduct();

    @Query("from Product as p where p.timesSold = (select max(pr.timesSold) from Product pr)")
    Product findMostSoldProduct();
}

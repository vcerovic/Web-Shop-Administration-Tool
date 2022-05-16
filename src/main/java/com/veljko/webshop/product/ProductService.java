package com.veljko.webshop.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    //LIST ALL PRODUCTS
    public List<Product> getAllProducts() {
        return productRepository.findAllByOrderByNameAsc();
    }

    //SAVE PRODUCT
    public ResponseEntity<String> saveProduct(Product product) {
        productRepository.save(product);
        return new ResponseEntity<>("Customer is created successfully", HttpStatus.CREATED);
    }

    //DELETE PRODUCT
    public ResponseEntity<String> deleteProductById(Integer id) {
        if (productRepository.findById(id).isEmpty()) {
            throw new RuntimeException("Did not find product id - " + id);
        }

        productRepository.deleteById(id);
        return new ResponseEntity<>("Product successfully deleted", HttpStatus.OK);
    }


    //FIND BY ID
    public Product findProductById(Integer id) {
        return productRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Did not find product id - " + id));
    }


    //UPDATE CUSTOMER
    public ResponseEntity<String> updateProduct(Integer id, Product newProduct) {
        Product oldProduct = findProductById(id);

        if (!newProduct.getId().equals(oldProduct.getId())) {
            throw new RuntimeException("Product's id doesn't match.");
        }

        productRepository.save(newProduct);
        return new ResponseEntity<>("Product successfully changed", HttpStatus.OK);
    }

    //COUNT ALL UNIQUE PRODUCTS
    public long countAllProducts() {
        return productRepository.count();
    }

    //FIND MOST SOLD PRODUCT
    public Product findMostSoldProduct() {
        Optional<Product> product = productRepository.findTopByOrderByTimesSoldDesc();

        return product.orElse(null);
    }

    //FIND MOST EXPENSIVE PRODUCT
    public Product findMostExpensiveProduct() {
        Optional<Product> product = productRepository.findTopByOrderByPriceDesc();

        return product.orElse(null);
    }

    //FIND PRODUCT WITH HIGHEST NUMBER IN STOCK
    public Product findMostStockProduct() {
        Optional<Product> product = productRepository.findTopByOrderByStockDesc();

        return product.orElse(null);
    }
}

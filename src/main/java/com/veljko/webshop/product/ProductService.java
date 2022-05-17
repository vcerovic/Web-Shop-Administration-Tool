package com.veljko.webshop.product;

import com.veljko.webshop.product.exception.ProductNotFoundException;
import com.veljko.webshop.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
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
    public ResponseEntity<String> saveProduct(Product product, MultipartFile image) {
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(image.getOriginalFilename()));
        String uploadDir = "src/main/resources/static/images/";

        try {
            FileUtil.saveFile(uploadDir, fileName, image);
        } catch (IOException e) {
            e.printStackTrace();
        }

        productRepository.save(product);
        return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
    }

    //DELETE PRODUCT
    public ResponseEntity<String> deleteProductById(Integer id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isEmpty()) {
            throw new ProductNotFoundException("Did not find product id - " + id);
        }

        FileUtil.deleteFile("src/main/resources/static" + product.get().getImage());
        productRepository.deleteById(id);

        return new ResponseEntity<>("Product successfully deleted", HttpStatus.OK);
    }


    //FIND BY ID
    public Product findProductById(Integer id) {
        return productRepository
                .findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Did not find product id - " + id));
    }


    //UPDATE CUSTOMER
    public ResponseEntity<String> updateProduct(Integer id, Product newProduct) {
        Product oldProduct = findProductById(id);

        if (!newProduct.getId().equals(oldProduct.getId())) {
            throw new ProductNotFoundException("Product's id doesn't match.");
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

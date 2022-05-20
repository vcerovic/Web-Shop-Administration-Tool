package com.veljko.webshop.product;

import com.veljko.webshop.product.exception.ProductImageSizeLimitException;
import com.veljko.webshop.product.exception.ProductNameAlreadyExistsException;
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
        return productRepository.findAllByOrderByIdAsc();
    }

    //SAVE PRODUCT
    public ResponseEntity<String> saveProduct(Product product, MultipartFile image) {
        if (productRepository.findByName(product.getName()).isPresent()) {
            throw new ProductNameAlreadyExistsException("Product with that name already exists!");
        }

        if (image.getSize() > 2e+6) {
            throw new ProductImageSizeLimitException("Only 2mb image size is allowed");
        }

        String fileName = product.getName().replaceAll(" ", "_").toLowerCase()
                + "_" + StringUtils.cleanPath(Objects.requireNonNull(image.getOriginalFilename()));

        String uploadDir = "images/";

        try {
            FileUtil.saveFile(uploadDir, fileName, image);
        } catch (IOException e) {
            e.printStackTrace();
        }

        product.setImage(fileName);
        productRepository.save(product);

        return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
    }

    //DELETE PRODUCT
    public ResponseEntity<String> deleteProductById(Integer id) {
        Optional<Product> product = productRepository.findById(id);

        if (product.isEmpty()) {
            throw new ProductNotFoundException("Did not find product id - " + id);
        }


        FileUtil.deleteFile("images/" + product.get().getImage());
        productRepository.deleteById(id);

        return new ResponseEntity<>("Product successfully deleted", HttpStatus.OK);
    }


    //FIND BY ID
    public Product findProductById(Integer id) {
        return productRepository
                .findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Did not find product id - " + id));
    }


    //UPDATE PRODUCT
    public ResponseEntity<String> updateProduct(Integer id, Product newProduct, MultipartFile image) {
        Product oldProduct = findProductById(id);

        if (!newProduct.getId().equals(id)) {
            throw new ProductNotFoundException("Product's id doesn't match.");
        }

        if (image.getSize() > 2e+6) {
            throw new ProductImageSizeLimitException("Only 2mb image size is allowed");
        }

        if (!oldProduct.getName().equals(newProduct.getName())) {
            if (productRepository.findByName(newProduct.getName()).isPresent()) {
                throw new ProductNameAlreadyExistsException("Product with " + newProduct.getName() + " already exists.");
            }
        }

        if (!oldProduct.getImage().equals(newProduct.getImage())) {
            String newProductFileName = newProduct.getName().replaceAll(" ", "_").toLowerCase()
                    + "_" + StringUtils.cleanPath(Objects.requireNonNull(image.getOriginalFilename()));

            String uploadDir = "images/";

            FileUtil.deleteFile(uploadDir + oldProduct.getImage());

            try {
                FileUtil.saveFile(uploadDir, newProductFileName, image);
            } catch (IOException e) {
                e.printStackTrace();
            }

            newProduct.setImage(newProductFileName);

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

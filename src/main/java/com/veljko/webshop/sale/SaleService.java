package com.veljko.webshop.sale;

import com.veljko.webshop.customer.Customer;
import com.veljko.webshop.customer.CustomerService;
import com.veljko.webshop.customer.exception.CustomerNotFoundException;
import com.veljko.webshop.product.Product;
import com.veljko.webshop.product.ProductRepository;
import com.veljko.webshop.product.ProductService;
import com.veljko.webshop.product.exception.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Service
public class SaleService {
    private final ProductService productService;
    private final SaleRepository saleRepository;
    private final ProductRepository productRepository;
    private final CustomerService customerService;

    @Autowired
    public SaleService(ProductService productService, SaleRepository saleRepository, ProductRepository productRepository, CustomerService customerService) {
        this.productService = productService;
        this.saleRepository = saleRepository;
        this.productRepository = productRepository;
        this.customerService = customerService;
    }

    //LIST ALL SALES
    public List<Sale> getAllSales() {
        return saleRepository.findAll();
    }

    //SAVE SALE (/sales)
    public ResponseEntity<String> saveSale(Integer customerId, Integer productId) {
        try {
            Product product = productService.findProductById(productId);
            Customer customer = customerService.findCustomerById(customerId);

            Set<Customer> customersSet = new LinkedHashSet<>();
            customersSet.add(customer);
            product.setCustomers(customersSet);

            Set<Product> productsSet = new LinkedHashSet<>();
            productsSet.add(product);
            customer.setProducts(productsSet);


            productRepository.save(product);
            return new ResponseEntity<>("Sale successfully created", HttpStatus.OK);
        } catch (ProductNotFoundException | CustomerNotFoundException exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
        }

    }

}

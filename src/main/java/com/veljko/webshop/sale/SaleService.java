package com.veljko.webshop.sale;

import com.veljko.webshop.customer.Customer;
import com.veljko.webshop.customer.CustomerRepository;
import com.veljko.webshop.customer.exception.CustomerNotFoundException;
import com.veljko.webshop.product.Product;
import com.veljko.webshop.product.ProductRepository;
import com.veljko.webshop.product.exception.ProductNotFoundException;
import com.veljko.webshop.product.exception.ProductOutOfStockException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class SaleService {
    private final ProductRepository productRepository;
    private final CustomerRepository customerRepository;

    @Autowired
    public SaleService(ProductRepository productRepository, CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
    }


    //SAVE SALE (/sales)
    public ResponseEntity<String> saveSale(Integer customerId, Integer productId, int quantity) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException("Product with: " + productId +
                        " id doesn't exist."));

        Customer customer = customerRepository
                .findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException("Customer with: " + customerId +
                        " id doesn't exist."));

        if (product.getStock() < 1) {
            throw new ProductOutOfStockException("Product " + product.getName() + " is out of stock.");
        }

        if (product.getStock() < quantity) {
            throw new ProductOutOfStockException("There are only " +
                    product.getStock() + " " + product.getName() + " left.");
        }


        customer.setPurchases(customer.getPurchases() + quantity);
        customer.setSpent(customer.getSpent() + (product.getPrice() * quantity));

        product.setTimesSold(product.getTimesSold() + quantity);
        product.setStock(product.getStock() - quantity);


        Sale sale = new Sale(customer, product, new Date(), quantity);

        customer.getSales().add(sale);
        customerRepository.save(customer);

        return new ResponseEntity<>("Sale successfully created", HttpStatus.OK);
    }

}

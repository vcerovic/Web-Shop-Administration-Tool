package com.veljko.webshop.sale;

import com.veljko.webshop.customer.Customer;
import com.veljko.webshop.customer.CustomerRepository;
import com.veljko.webshop.customer.exception.CustomerNotFoundException;
import com.veljko.webshop.product.Product;
import com.veljko.webshop.product.ProductRepository;
import com.veljko.webshop.product.exception.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleService {
    private final SaleRepository saleRepository;
    private final ProductRepository productRepository;
    private final CustomerRepository customerRepository;

    @Autowired
    public SaleService(SaleRepository saleRepository,
                       ProductRepository productRepository,
                       CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
        this.saleRepository = saleRepository;
        this.productRepository = productRepository;
    }

    //LIST ALL SALES
    public List<Sale> getAllSales() {
        return saleRepository.findAll();
    }

    //SAVE SALE (/sales)
    public ResponseEntity<String> saveSale(Integer customerId, Integer productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException("Product with: " + productId +
                        " id doesn't exist."));

        Customer customer = customerRepository
                .findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException("Customer with: " + customerId +
                        " id doesn't exist."));

        customer.setPurchases(customer.getPurchases() + 1);
        customer.setSpent(customer.getSpent() + product.getPrice());

        product.setTimesSold(product.getTimesSold() + 1);
        product.setStock(product.getStock() - 1);

        product.getCustomers().add(customer);
        customer.getProducts().add(product);


        productRepository.save(product);
        return new ResponseEntity<>("Sale successfully created", HttpStatus.OK);
    }

}

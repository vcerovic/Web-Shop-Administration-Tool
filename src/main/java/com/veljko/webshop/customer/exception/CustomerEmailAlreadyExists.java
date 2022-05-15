package com.veljko.webshop.customer.exception;


public class CustomerEmailAlreadyExists extends RuntimeException {

    public CustomerEmailAlreadyExists(String message) {
        super(message);
    }

}

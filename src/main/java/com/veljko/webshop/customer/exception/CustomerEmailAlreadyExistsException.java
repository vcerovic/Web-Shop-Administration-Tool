package com.veljko.webshop.customer.exception;


public class CustomerEmailAlreadyExistsException extends RuntimeException {

    public CustomerEmailAlreadyExistsException(String message) {
        super(message);
    }

}

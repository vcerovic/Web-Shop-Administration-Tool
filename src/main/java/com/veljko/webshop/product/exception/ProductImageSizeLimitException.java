package com.veljko.webshop.product.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ProductImageSizeLimitException extends RuntimeException {
    public ProductImageSizeLimitException(String message) {
        super(message);
    }
}

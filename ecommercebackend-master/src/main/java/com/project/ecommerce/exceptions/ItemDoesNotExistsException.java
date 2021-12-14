package com.project.ecommerce.exceptions;

public class ItemDoesNotExistsException extends RuntimeException {
    public ItemDoesNotExistsException(String message) {
        super(message);
    }
}

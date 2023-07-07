package com.practice.store.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundProductException extends RuntimeException{
    public NotFoundProductException(int id) {
        super("Product with id=" + id + " not found");
    }
}
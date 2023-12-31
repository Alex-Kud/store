package com.practice.store.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundBuyerException extends RuntimeException{
    public NotFoundBuyerException(int id) {
        super("Buyer with id=" + id + " not found");
    }
}

package com.myshop.service;

import com.myshop.book.Book;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by max on 13.12.2015.
 */
@ResponseStatus(HttpStatus.CONFLICT)
public class ItemAlreadyExistedException extends RuntimeException {
    public ItemAlreadyExistedException(Book book) {
        super(book.toString());
    }
}

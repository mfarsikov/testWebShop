package com.myshop.service;

import com.myshop.book.Book;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by max on 12.12.2015.
 */

public interface BookShopService {

    List<Book> bookList();

    void addBook(Book book);

    boolean isBookExist(Book book);
}

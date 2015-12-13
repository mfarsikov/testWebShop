package com.myshop.service;

import com.myshop.book.Book;

import java.util.List;

/**
 * Created by max on 12.12.2015.
 */

public interface BookShopService {

    List<Book> bookList();

    Book addBook(Book book);
}

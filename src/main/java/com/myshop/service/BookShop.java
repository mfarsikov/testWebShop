package com.myshop.service;

import com.myshop.book.Book;
import com.myshop.book.BookDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by max on 12.12.2015.
 */
@Service
public class BookShop implements BookShopService {

    private BookDAO bookDAO;

    @Autowired
    public BookShop(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    @Override
    public List<Book> bookList() {
        return bookDAO.getAllBooks();
    }

    @Override
    public void addBook(Book book) {
        bookDAO.addBook(book);
    }

    @Override
    public boolean isBookExist(Book book) {
        return bookDAO.findBookById(book.getId()) != null;
    }

}

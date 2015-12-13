package com.myshop.service;

import com.myshop.book.Book;
import com.myshop.book.BookDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by max on 12.12.2015.
 */
@Service
public class BookShop implements BookShopService {

    private BookDAO bookDAO;
    private volatile AtomicInteger counter;

    @Autowired
    public BookShop(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    @PostConstruct
    public void init() {
        counter = new AtomicInteger(bookDAO.count());
    }

    @Override
    public List<Book> bookList() {
        return bookDAO.getAllBooks();
    }

    @Override
    public Book addBook(Book book) {
        Optional<Book> bookByAuthorAndTitle = bookDAO.findBookByAuthorAndTitle(book.getAuthor(), book.getTitle());
        if (bookByAuthorAndTitle.isPresent()) {
            throw new ItemAlreadyExistedException(bookByAuthorAndTitle.get());
        }
        Book saved = new Book(generateId(), book.getAuthor(), book.getTitle());
        bookDAO.addBook(saved);
        return saved;
    }

    private Integer generateId() {
        return counter.incrementAndGet();
    }
}

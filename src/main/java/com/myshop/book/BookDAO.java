package com.myshop.book;

import java.util.List;
import java.util.Optional;

/**
 * Created by Kot on 12.12.15.
 */
public interface BookDAO {

    Optional<Book> findBookByAuthorAndTitle(String author, String title);

    Optional<Book> findBookByTitle(String title);

    List<Book> findBookByAuthor(String author) ;

    List<Book> getAllBooks();

    void addBook(Book book);

    int count();
}

package com.myshop.book;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by Kot on 12.12.15.
 */
@Repository
public class TestBookDAO implements BookDAO {

    List<Book> books = Arrays.asList(new Book(1, "Mr biggls", "Spring in Action"),
                                     new Book(2, "Mr brightside", "Java 8 in action"));

    @Override
    public Optional<Book> findBookById(Integer id) {
        return books.stream().filter(book -> book.getId().equals(id)).findFirst();

    }

    @Override
    public Optional<Book> findBookByTitle(String title) {
        return books.stream().filter(book -> book.getTitle().equals(title)).findFirst();
    }

    @Override
    public List<Book> findBookByAuthor(String author) {
       return books.stream().filter(book->book.getAuthor().equals(author)).collect(Collectors.toList());
    }

    @Override
    public List<Book> getAllBooks() {
        return books;
    }
}

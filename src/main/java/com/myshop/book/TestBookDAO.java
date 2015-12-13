package com.myshop.book;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by Kot on 12.12.15.
 */
@Repository
public class TestBookDAO implements BookDAO {

    List<Book> books = new ArrayList(Arrays.asList(new Book(1, "Mr biggls", "Spring in Action"),
            new Book(2, "Mr brightside", "Java 8 in action")));

    @Override
    public Optional<Book> findBookByAuthorAndTitle(String author, String title) {
        Predicate<Book> sameAuthor = equalPredicate(Book::getAuthor, author);
        Predicate<Book> sameTitle = equalPredicate(Book::getTitle, title);

        return books.stream()
                .filter(sameAuthor.and(sameTitle))
                .findFirst();
    }

    public Predicate<Book> equalPredicate(Function<Book, String> stringExtractor, String value) {
        return book -> stringExtractor.apply(book).equals(value);
    }

    @Override
    public Optional<Book> findBookByTitle(String title) {
        Predicate<Book> sameTitle = equalPredicate(Book::getTitle, title);
        return books.stream()
                .filter(sameTitle)
                .findFirst();
    }

    @Override
    public List<Book> findBookByAuthor(String author) {
        Predicate<Book> sameAuthor = equalPredicate(Book::getAuthor, author);
        return books.stream()
                .filter(sameAuthor)
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> getAllBooks() {
        return books;
    }

    @Override
    public void addBook(Book book) {
        books.add(book);
    }

    @Override
    public int count() {
        return books.size();
    }
}

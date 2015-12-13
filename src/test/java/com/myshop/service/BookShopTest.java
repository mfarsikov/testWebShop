package com.myshop.service;

import com.myshop.book.Book;
import com.myshop.book.BookDAO;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.util.Assert;

import java.util.Optional;

/**
 * Created by max on 13.12.2015.
 */
public class BookShopTest {
    @Test
    public void idShouldBeAssigned() {
        BookDAO repo = Mockito.mock(BookDAO.class);
        Mockito.when(repo.findBookByAuthorAndTitle("Pushkin", "Eugen O."))
                .thenReturn(Optional.empty());

        BookShop shop = new BookShop(repo);
        Book book = new Book("Pushkin", "Eugen O.");
        book = shop.addBook(book);
        Assert.notNull(book.getId());
    }

    @Test(expected = ItemAlreadyExistedException.class)
    public void onDuplicationExceptionShouldBeThrown() {
        BookDAO repo = Mockito.mock(BookDAO.class);
        Mockito.when(repo.findBookByAuthorAndTitle("Pushkin", "Eugen O."))
                .thenReturn(Optional.of(new Book()));

        BookShop bookShop = new BookShop(repo);

        bookShop.addBook(new Book("Pushkin", "Eugen O."));
    }
}

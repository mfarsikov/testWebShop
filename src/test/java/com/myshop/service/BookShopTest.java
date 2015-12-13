package com.myshop.service;

import com.myshop.book.Book;
import com.myshop.book.BookDAO;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.util.Assert;

import java.util.Optional;

/**
 * Created by max on 13.12.2015.
 */
public class BookShopTest {

    BookShop shop;
    BookDAO repo;

    @Before
    public void init(){
        repo = Mockito.mock(BookDAO.class);
        shop = new BookShop(repo);
        shop.init();
    }

    @Test
    public void idShouldBeAssigned() {
        Mockito.when(repo.findBookByAuthorAndTitle("Pushkin", "Eugen O."))
                .thenReturn(Optional.empty());

        Book book = new Book("Pushkin", "Eugen O.");
        book = shop.addBook(book);
        Assert.notNull(book.getId());
    }

    @Test(expected = ItemAlreadyExistedException.class)
    public void onDuplicationExceptionShouldBeThrown() {
        Mockito.when(repo.findBookByAuthorAndTitle("Pushkin", "Eugen O."))
                .thenReturn(Optional.of(new Book()));

        shop.addBook(new Book("Pushkin", "Eugen O."));
    }
}

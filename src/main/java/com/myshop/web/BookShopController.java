package com.myshop.web;

import com.myshop.book.Book;
import com.myshop.service.BookShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Kot on 12.12.15.
 */
@RestController()
@RequestMapping("/shop")
public class BookShopController {

    private BookShopService bookShop;

    @Autowired
    public BookShopController(BookShopService bookShop) {
        this.bookShop = bookShop;
    }

    @RequestMapping(value = "/books", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Book> items() {
        return bookShop.bookList();
    }

}
